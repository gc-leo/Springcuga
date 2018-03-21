package com.example.demo;

import com.example.demo.domain.Coin;
import com.example.demo.repositories.CoinRepository;
import com.example.demo.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Each time application is runed clear all data and fill it with seed data
 */
@SpringBootApplication
public class Seeds implements CommandLineRunner {

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private CoinService coinService;

    public void run(String... args) throws Exception {

        //clean repo
        coinRepository.deleteAll();

        // seed few coins
        coinRepository.save(new Coin("Bitcoin","BTC"));
        coinRepository.save(new Coin("Etherium","ETH"));
        coinRepository.save(new Coin("Euro","EUR"));
        coinRepository.save(new Coin("Dollar","USD"));
        coinRepository.save(new Coin("SerbianDinar","RSD"));

        for(int i = 0; i<5; i++){
            coinRepository.save(new Coin("Name"+i,"Cryptoname"+i));
        }

        //Sets currencies dollar value
        coinService.setCurrenciesDollarValue();

        //check if its inserted and print them
        System.out.println("Coins found with findAll():");
        System.out.println("-------------------------------");
        for (Coin coin : coinRepository.findAll()) {
            System.out.println(coin);
        }
        System.out.println();

    }
}
