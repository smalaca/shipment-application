package com.smalaca.shipment.shipment.infrastructure.trucksmanagement.rest;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;

@Service
public class TrucksManagementClient {
    private static final String URL = "http://localhost:8105";

    private final RestTemplate restTemplate;

    public TrucksManagementClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<AvailableTruck> getAllAvailable(String startPoint, LocalDate startDate, String endPoint, LocalDate endDate) {
        URI url = UriComponentsBuilder.fromHttpUrl(URL + "/truck/available")
                .queryParam("startPoint", startPoint)
                .queryParam("startDate", startDate)
                .queryParam("endPoint", endPoint)
                .queryParam("endDate", endDate)
                .build().toUri();

        return asList(restTemplate.getForObject(url, AvailableTruck[].class));
    }
}
