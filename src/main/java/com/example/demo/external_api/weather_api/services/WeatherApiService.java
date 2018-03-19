package com.example.demo.external_api.weather_api.services;

import com.example.demo.external_api.weather_api.domain.Weather;

public interface WeatherApiService {

    Weather getWeatherByCity(String city);

}
