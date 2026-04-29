package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {


    @Mock
    private Temperatures temperaturesMock;
    private Map<String, Double> temperaturesMap;

    @BeforeEach
    void setUp() {
        temperaturesMap = Map.of(
                "Krakow", 15.0,
                "Warszawa", 25.0,
                "Gdansk", 20.0);
    }

     @Test
     void testCalculateForecastWithMock() {
         //Given
         when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
         WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

         //When
         int quantityOfSensors = weatherForecast.calculateForecast().size();

         //Then
         assertEquals(3, quantityOfSensors);
     }

    @Test
    void testCalculateAverageTemperature() {
        //given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast forecast = new WeatherForecast(temperaturesMock);

        // when
        double result = forecast.calculateAverageTemperature();

        // then
        assertEquals(20.0, result);
    }

    @Test
    void testCalculateMedianTemperature() {
         //given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast forecast = new WeatherForecast(temperaturesMock);

        // when
        double result = forecast.calculateMedianTemperature();

        // then
        assertEquals(20.0, result);
    }
}

