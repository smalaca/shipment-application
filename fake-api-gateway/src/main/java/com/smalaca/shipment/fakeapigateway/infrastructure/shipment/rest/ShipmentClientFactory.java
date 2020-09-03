package com.smalaca.shipment.fakeapigateway.infrastructure.shipment.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ShipmentClientFactory {
    @Bean
    public ShipmentClient shipmentClient() {
        return new ShipmentClient(new RestTemplate());
    }
}
