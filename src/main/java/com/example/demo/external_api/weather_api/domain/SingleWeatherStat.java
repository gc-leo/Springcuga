package com.example.demo.external_api.weather_api.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SingleWeatherStat {

    private int id;
    private String main;
    private String description;

}
