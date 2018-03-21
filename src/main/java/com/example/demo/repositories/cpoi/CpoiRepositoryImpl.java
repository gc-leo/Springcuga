package com.example.demo.repositories.cpoi;

import org.springframework.data.mongodb.core.MongoTemplate;

public class CpoiRepositoryImpl implements CpoiRepositoryCustom {

    private MongoTemplate mongoTemplate;

    public CpoiRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }




}
