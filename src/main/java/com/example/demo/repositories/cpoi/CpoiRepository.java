package com.example.demo.repositories.cpoi;

import com.example.demo.domain.Cpoi;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CpoiRepository extends MongoRepository<Cpoi, String>, CpoiRepositoryCustom {


}
