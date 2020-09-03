package com.smalaca.shipment.fakeapigateway.infrastructure.shipment.rest;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class ShipmentClient {
    private static final String URL = "http://localhost:8102";

    private final RestTemplate restTemplate;

    ShipmentClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String requestShipmentOffer() {
        return restTemplate.postForObject(URL + "/offer", null, String.class);
    }

    public List<ShipmentOfferDto> getShipmentOffer(String id) {
        ShipmentOfferDto[] response = restTemplate.getForObject(URL + "/offer/" + id, ShipmentOfferDto[].class);
        return Arrays.asList(response);
    }
}
