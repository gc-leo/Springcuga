package com.example.demo;

import com.example.demo.external_api.criptocompare_api.services.CryptoExchangeApiService;

import com.example.demo.external_api.weather_api.services.WeatherApiService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        WeatherApiService weatherApiService = (WeatherApiService) context.getBean("weatherApiServiceImpl");

//        CryptoExchangeService cryptoExchangeService = (CryptoExchangeService) context.getBean("cryptoExchangeServiceImpl");

        CryptoExchangeApiService cryptoExchangeApiService = (CryptoExchangeApiService) context.getBean("cryptoExchangeApiServiceImpl");


        List<String> currencyList = new ArrayList<>();
        currencyList.add("BTC");
        currencyList.add("ETH");
        currencyList.add("USD");
        currencyList.add("EUR");
        currencyList.add("RSD");

        String baseCurency = "BTC";

        System.out.println(cryptoExchangeApiService.getCryptoCurrencyPriceByValute(baseCurency, currencyList));

//        System.out.println(cryptoExchangeService.getCryptoCurrencyPriceByValute(baseCurency, currencyList));
//        System.out.println("=====================================");

        System.out.println(weatherApiService.getWeatherByCity("Belgrade"));

    }
}