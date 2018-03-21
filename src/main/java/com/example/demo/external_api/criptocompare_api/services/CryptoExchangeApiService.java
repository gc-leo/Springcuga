package com.example.demo.external_api.criptocompare_api.services;

import com.example.demo.external_api.criptocompare_api.domain.CryptoCurrencyPrice;

import java.util.List;

public interface CryptoExchangeApiService {

    CryptoCurrencyPrice getCryptoCurrencyPriceByValute(String baseCurrency, List<String> currencies);
    CryptoCurrencyPrice getCryptoCurrencyPriceByValute(String baseCurrency);
}
