package com.example.demo;

import com.example.demo.domain.*;
import com.example.demo.repositories.CoinRepository;
import com.example.demo.repositories.MemberRepository;
import com.example.demo.services.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.SecureRandom;
import java.util.*;

/**
 * Each time application is runed clear all data and fill it with seed data
 */
@SpringBootApplication
public class Seeds implements CommandLineRunner {

    @Autowired
    private CoinRepository coinRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private CoinService coinService;

    public enum Roles { admin, moderator, user }

    private Roles getRadnomRole(){
        return Roles.values()[new Random().nextInt(Roles.values().length)];
    }

    public void run(String... args) throws Exception {

        //clean repo
        coinRepository.deleteAll();
        memberRepository.deleteAll();

        // seed few coins
        coinRepository.save(new Coin("Bitcoin", "BTC"));
        coinRepository.save(new Coin("Etherium", "ETH"));
        coinRepository.save(new Coin("Euro", "EUR"));
        coinRepository.save(new Coin("Dollar", "USD"));
        coinRepository.save(new Coin("SerbianDinar", "RSD"));

        List<Roles> roles = new ArrayList<>();
        Collections.addAll(roles, Roles.values());
        Collections.shuffle(roles);

        //seed few more coins, members
        for (int i = 0; i < 5; i++) {
            coinRepository.save( Coin.builder().name("CoinName" + i).criptoname("CRYPTO"+ i).build());

            Member seed_member = Member.builder().name("User" + i).avatar("avatar.jpg")
                    .contact(Contact.builder().value("value").is_default(true)
                            .type(ContactType.builder().email("random" + i + "@gmail.com").phone("123" + i + "123").address("Ulica" + i).build())
                            .build()
                    )
                    .credentials(Credentials.builder().provider("provider" + i).principal("principal" + i).secret("s3cret").password("123").role(getRadnomRole().name())
                            .build()
                    )
                    .build();
            memberRepository.save(seed_member);
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

        System.out.println("Members found with findAll():");
        System.out.println("-------------------------------");
        for (Member member : memberRepository.findAll()) {
            System.out.println(member);
        }
        System.out.println();

    }
}
