package com.example.demo.repositories;

import com.example.demo.domain.Cpoi;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface CpoiRepository extends MongoRepository<Cpoi, String> {

//    @Query("{'location': {$geoWithin: { $centerSphere: [ [ ?0, ?1 ], 0.55091 ]}}}")
    @Query("{'location': {$geoWithin: { $centerSphere: [ [ ?0, ?1 ], ?2 ]}}}")
    List<Cpoi> findNearByCpoisByLocation(Float lat, Float lng, Float radius);
}
