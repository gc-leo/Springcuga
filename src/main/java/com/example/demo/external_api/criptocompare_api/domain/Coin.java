package com.example.demo.external_api.criptocompare_api.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Coin {

    public String id;
    public String name;
    public String criptoname;
    public double value;

}
