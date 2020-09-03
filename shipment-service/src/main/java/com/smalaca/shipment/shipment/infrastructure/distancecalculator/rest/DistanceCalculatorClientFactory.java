package com.smalaca.shipment.shipment.infrastructure.distancecalculator.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DistanceCalculatorClientFactory {
    @Bean
    public DistanceCalculatorClient distanceCalculatorClient() {
        return new DistanceCalculatorClient(new RestTemplate());
    }
}
