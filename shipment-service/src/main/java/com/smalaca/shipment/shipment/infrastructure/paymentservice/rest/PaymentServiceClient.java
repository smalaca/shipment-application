package com.smalaca.shipment.shipment.infrastructure.paymentservice.rest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class PaymentServiceClient {
    private static final String URL = "http://localhost:8104";

    private final RestTemplate restTemplate;

    public PaymentServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Price calculateFor(double length, String metric, String truckId) {
        URI url = UriComponentsBuilder.fromHttpUrl(URL + "/price")
                .queryParam("length", length)
                .queryParam("metric", metric)
                .queryParam("truckId", truckId)
                .build().toUri();

        return restTemplate.getForObject(url, Price.class);
    }
}
