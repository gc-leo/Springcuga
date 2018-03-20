package com.example.demo.external_api.coin_market_cap_api.services;

import com.example.demo.external_api.coin_market_cap_api.domain.CoinInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoinMarketCapApiServiceImpl implements CoinMarketCapApiService {

    RestTemplate restTemplate;

    public CoinMarketCapApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CoinInfo getCoinInfo(String coin_name) {

        CoinInfo[] infos = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/bitcoin", CoinInfo[].class);

        return infos[0];
    }
}
