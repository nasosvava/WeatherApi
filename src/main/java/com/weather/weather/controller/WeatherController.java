package com.weather.weather.controller;

import com.weather.weather.domain.Weather;
import com.weather.weather.domain.WeatherForecast;
import com.weather.weather.service.impl.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    private final WeatherServiceImpl weatherService;


    public WeatherController(WeatherServiceImpl weatherService) {
        this.weatherService = weatherService;
    }


    @RequestMapping("/now/{country}/{city}")
    public Weather getWeather(@PathVariable String country,
                              @PathVariable String city) {
        return this.weatherService.getWeather(country, city);
    }

    @RequestMapping("/weekly/{country}/{city}")
    public WeatherForecast getWeatherForecast(@PathVariable String country,
                                              @PathVariable String city) {
        return this.weatherService.getWeatherForecast(country, city);
    }
}
