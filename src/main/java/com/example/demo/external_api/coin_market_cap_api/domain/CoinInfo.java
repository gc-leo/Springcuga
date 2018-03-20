package com.example.demo.external_api.coin_market_cap_api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class CoinInfo {

    private String id;
    private String name;
    private String symbol;
    private String rank;
    private Double price_usd;
    private Double price_btc;
    @JsonProperty("24h_volume_usd")
    private Double _24h_volume_usd;
    private Double market_cap_usd;
    private Double available_supply;
    private Double total_supply;
    private Double max_supply;
    private Double percent_change_1h;
    private Double percent_change_24h;
    private Double percent_change_7d;
    private Date last_updated;
}
