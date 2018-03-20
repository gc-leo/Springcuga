package com.example.demo;

import com.example.demo.external_api.coin_market_cap_api.services.CoinMarketCapApiService;
import com.example.demo.external_api.weather_api.services.WeatherApiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}