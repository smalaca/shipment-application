package com.smalaca.shipment.shipment.infrastructure.historyregistry.rest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HistoryRegistryClient {
    private static final String URL = "http://localhost:8107";

    private final RestTemplate restTemplate;

    public HistoryRegistryClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void requestShipmentOffer(ShipmentOfferParameters shipmentOfferParameters) {
        restTemplate.postForObject(URL + "/offer", shipmentOfferParameters, Void.class);
    }
}
