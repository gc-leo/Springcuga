package com.example.demo.external_api.criptocompare_api.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CryptoCurrencyPrice {

    public double BTC;
    public double ETH;
    public double USD;
    public double EUR;
    public double RSD;

}
