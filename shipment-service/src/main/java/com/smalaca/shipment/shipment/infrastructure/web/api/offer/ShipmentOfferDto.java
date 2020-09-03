package com.smalaca.shipment.shipment.infrastructure.web.api.offer;

class ShipmentOfferDto {
    private final String id;
    private final String name;

    ShipmentOfferDto(String id, String name) {
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