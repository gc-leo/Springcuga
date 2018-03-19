package com.example.demo.external_api.weather_api.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MainWeatherStats {

    private float temp;
    private float pressure;
    private float humidity;
    private float temp_min;
    private float temp_max;

}
