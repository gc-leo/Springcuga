package com.example.demo.repositories;

import com.example.demo.domain.Exchange;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExchangeRepository extends MongoRepository<Exchange, String>{
}
