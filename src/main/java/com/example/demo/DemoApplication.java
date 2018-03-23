package com.example.demo;

import com.example.demo.domain.jwt.JwtUser;
import com.example.demo.repositories.cpoi.CpoiRepository;
import com.example.demo.security.JwtGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        CpoiRepository cpoiRepository = (CpoiRepository) context.getBean("cpoiRepository");
        cpoiRepository.testAgregation("string");
        JwtGenerator jwtGenerator = (JwtGenerator) context.getBean("jwtGenerator");
        JwtUser jwtUser = new JwtUser();
        jwtUser.setUsername("pera");
        jwtUser.setId("asdasdasdasds");
        jwtUser.setRole("admin");
        System.out.println(jwtGenerator.generate(jwtUser));

    }
}