package com.example.demo.external_api.coin_market_cap_api.services;

import com.example.demo.external_api.coin_market_cap_api.domain.CoinInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CoinMarketCapApiServiceImpl implements CoinMarketCapApiService {

    private RestTemplate restTemplate;
    private final String api_url;


    public CoinMarketCapApiServiceImpl(RestTemplate restTemplate, @Value("${coinmarketcap.api.url}") String api_url) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
    }

    @Override
    public CoinInfo getCoinInfo(String coin_name) {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .path(coin_name);

        CoinInfo[] infos = restTemplate.getForObject(uriComponentsBuilder.toUriString(), CoinInfo[].class);

        return infos[0];
    }
}
