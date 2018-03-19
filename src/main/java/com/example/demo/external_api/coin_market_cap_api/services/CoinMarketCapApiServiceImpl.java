package com.example.demo.external_api.coin_market_cap_api.services;

import com.example.demo.external_api.coin_market_cap_api.domain.CoinInfo;
import com.example.demo.external_api.coin_market_cap_api.domain.CoinInfos;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoinMarketCapApiServiceImpl implements CoinMarketCapApiService {

    RestTemplate restTemplate;

    public CoinMarketCapApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CoinInfos getCoinInfo(String coin_name) {

        CoinInfos infos = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/" + coin_name, CoinInfos.class);

        return infos;
    }
}
