package com.example.demo.external_api.coin_market_cap_api.services;

import com.example.demo.external_api.coin_market_cap_api.domain.CoinInfos;

public interface CoinMarketCapApiService {

    CoinInfos getCoinInfo(String coin_name);
}
