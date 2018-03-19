package com.example.demo.external_api.weather_api.services;

import com.example.demo.external_api.weather_api.domain.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherApiServiceImpl implements WeatherApiService {


    private RestTemplate restTemplate;

    private final String api_url;

    private final String api_key;

    public WeatherApiServiceImpl(RestTemplate restTemplate, @Value("${weather.api.url}") String api_url, @Value("${weather.api.api_key}") String api_key) {
        this.restTemplate = restTemplate;
        this.api_url = api_url;
        this.api_key = api_key;
    }

    @Override
    public Weather getWeatherByCity(String city) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(api_url)
                .queryParam("q", city)
                .queryParam("apikey", api_key);
        Weather weather = restTemplate.getForObject(uriComponentsBuilder.toUriString(), Weather.class);
        return weather;
    }
}
