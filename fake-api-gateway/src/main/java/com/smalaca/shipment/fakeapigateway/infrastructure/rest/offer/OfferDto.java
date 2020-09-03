package com.smalaca.shipment.fakeapigateway.infrastructure.rest.offer;

public class OfferDto {
    private final String id;
    private final String name;

    OfferDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
