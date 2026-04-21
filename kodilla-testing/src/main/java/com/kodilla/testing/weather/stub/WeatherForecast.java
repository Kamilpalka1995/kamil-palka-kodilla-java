package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature() {
        Map<String, Double> temps = temperatures.getTemperatures();

        if (temps.isEmpty()) {
            throw new IllegalArgumentException("Brak danych");
        }

        double sum = 0;

        for (Double temp : temps.values()) {
            sum += temp;
        }

        return sum / temps.size();
    }

    public double calculateMedianTemperature() {
        Map<String, Double> temps = temperatures.getTemperatures();

        if (temps.isEmpty()) {
            throw new IllegalArgumentException("Brak danych");
        }

        List<Double> values = new ArrayList<>(temps.values());
        Collections.sort(values);

        int size = values.size();

        if (size % 2 == 1) {
            return values.get(size / 2);
        } else {
            double middle1 = values.get(size / 2 - 1);
            double middle2 = values.get(size / 2);
            return (middle1 + middle2) / 2.0;
        }
    }
}
