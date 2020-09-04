package com.smalaca.shipment.shipment.infrastructure.distancecalculator.rest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DistanceCalculatorClient {
    private static final String URL = "http://localhost:8103";

    private final RestTemplate restTemplate;

    DistanceCalculatorClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Distance calculate(String start, String destination) {
        return restTemplate.getForObject(URL + "/distance/" + start + "/" + destination, Distance.class);
    }
}
