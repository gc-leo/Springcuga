package com.example.demo.repositories.cpoi;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.sort;

public class CpoiRepositoryImpl implements CpoiRepositoryCustom {

    private MongoTemplate mongoTemplate;

    public CpoiRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public void testAgregation(String description) {
        MatchOperation matchOperation = Aggregation.match(new Criteria("description").is("string"));
        GroupOperation groupOperation = Aggregation.group("location.lon")
                .sum("location.lat").as("latSum")
                .min("location.lon").as("lonMin");
        ProjectionOperation projectionOperation = Aggregation.project()
                .andExpression("latSum").as("Sum")
                .andExpression("lonMin").as("Min")
                .andExclude("_id");
        SortOperation sortByPopDesc = sort(new Sort(Sort.Direction.DESC, "Min"));
        MatchOperation postMatchOperation = Aggregation.match(Criteria.where("Min").gt(5)
                .andOperator(Criteria.where("Min").lt(7)));
        Aggregation aggregation = Aggregation.newAggregation(matchOperation, groupOperation, projectionOperation, sortByPopDesc, postMatchOperation);
        AggregationResults results = mongoTemplate.aggregate(aggregation, "cpoi", Object.class);
        for (Object object : results.getMappedResults()) {
            System.out.println(object);
        }

    }
}
