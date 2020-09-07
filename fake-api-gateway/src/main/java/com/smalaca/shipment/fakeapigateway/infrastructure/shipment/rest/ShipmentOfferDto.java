package com.smalaca.shipment.fakeapigateway.infrastructure.shipment.rest;

import java.util.List;

public class ShipmentOfferDto {
    private String id;
    private Distance distance;
    private Price price;
    private String truckId;
    private List<String> warehouseIds;

    public String getId() {
        return id;
    }

    public Distance getDistance() {
        return distance;
    }

    public Price getPrice() {
        return price;
    }

    public String getTruckId() {
        return truckId;
    }

    public List<String> getWarehouseIds() {
        return warehouseIds;
    }
}
