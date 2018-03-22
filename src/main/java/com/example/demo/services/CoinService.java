package com.example.demo.services;

import com.example.demo.domain.Coin;
import com.example.demo.repositories.CoinRepository;
import org.springframework.stereotype.Service;

@Service
public class CoinService extends CrudService<Coin, String, CoinRepository> {

    public CoinService(CoinRepository repository) {
        super(repository);
    }

}
