package com.smalaca.shipment.shipment.infrastructure.warehousemanagement.rest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@Service
public class WarehouseManagementClient {
    private static final String URL = "http://localhost:8106";

    private final RestTemplate restTemplate;

    public WarehouseManagementClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Warehouse findAvailable(LocalDate start, LocalDate end) {
        URI url = UriComponentsBuilder.fromHttpUrl(URL + "/warehouse/available")
                .queryParam("start", start)
                .queryParam("end", end)
                .build().toUri();

        return restTemplate.getForObject(url, Warehouse.class);
    }
}
