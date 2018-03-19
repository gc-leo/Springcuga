package com.example.demo.external_api.weather_api.domain;

import com.example.demo.domain.Location;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Weather {

    private float visibility;
    private String city;
    private Location coord;
    private MainWeatherStats main;
    private List<SingleWeatherStat> weather;


}
