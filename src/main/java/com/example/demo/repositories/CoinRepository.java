package com.example.demo.repositories;

import com.example.demo.domain.Coin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoinRepository extends MongoRepository<Coin, String> {

    Coin findCoinByCriptoname(String cryptoname);

}
