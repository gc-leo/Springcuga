package com.example.demo.external_api.coin_market_cap_api.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CoinInfo {

    private String id;
    private String name;
    private String symbol;
    private String rank;
    private String priceUsd;
    private String priceBtc;
    private String _24hVolumeUsd;
    private String marketCapUsd;
    private String availableSupply;
    private String totalSupply;
    private String maxSupply;
    private String percentChange1h;
    private String percentChange24h;
    private String percentChange7d;
    private String lastUpdated;
}
