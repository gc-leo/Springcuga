package com.example.demo.external_api.criptocompare_api.services;

import com.example.demo.external_api.criptocompare_api.domain.CryptoCurrencyPrice;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class CryptoExchangeApiServiceImpl implements CryptoExchangeApiService{

    private RestTemplate restTemplate;

    @Value("${cryptocompare.api.url}")
    private String baseUrl;


    public CryptoExchangeApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CryptoCurrencyPrice getCryptoCurrencyPriceByValute(String baseCurrency, List<String> curencies) {

        //https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=BTC,USD,EUR,RSD
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(baseUrl)
                .queryParam("fsym",baseCurrency)   //should be Currency param
                .queryParam("tsyms",String.join(",", curencies));

        System.out.println(curencies);

        System.out.println(uriComponentsBuilder.toUriString());

        CryptoCurrencyPrice ccp = restTemplate.getForObject(uriComponentsBuilder.toUriString(), CryptoCurrencyPrice.class);
        return ccp;

    }
}
