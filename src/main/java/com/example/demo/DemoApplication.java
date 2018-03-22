package com.example.demo;

import com.example.demo.repositories.cpoi.CpoiRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        CpoiRepository cpoiRepository = (CpoiRepository) context.getBean("cpoiRepository");
        cpoiRepository.testAgregation("string");

    }
}