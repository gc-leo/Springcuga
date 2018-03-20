package com.example.demo.services;

import com.example.demo.domain.Cpoi;
import com.example.demo.external_api.weather_api.domain.Weather;
import com.example.demo.external_api.weather_api.services.WeatherApiService;
import com.example.demo.repositories.CpoiRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CpoiService extends CrudService<Cpoi, String, CpoiRepository> {

    private WeatherApiService weatherApiService;

    public CpoiService(CpoiRepository repository, WeatherApiService weatherApiService) {
        super(repository);
        this.weatherApiService = weatherApiService;
    }

    public Weather getWeatherForCpoi(String id) {
        Cpoi cpoi = getById(id);
        String city = cpoi.getAddress().getCity();
        return weatherApiService.getWeatherByCity(city);
    }

    public List<Cpoi> nearBy(Float lat, Float lng, Float radius){
        return getRepository().findNearByCpoisByLocation(lat, lng, radius);
    }
}
