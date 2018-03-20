package com.example.demo.external_api.coin_market_cap_api.services;

import com.example.demo.external_api.coin_market_cap_api.domain.CoinInfo;

public interface CoinMarketCapApiService {

    CoinInfo getCoinInfo(String coin_name);
}
