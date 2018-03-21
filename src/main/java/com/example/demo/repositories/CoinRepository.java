package com.example.demo.repositories;

import com.example.demo.domain.Coin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CoinRepository extends MongoRepository<Coin, String> {

    Optional<Coin> findCoinByCriptoname(String cryptoname);

}
