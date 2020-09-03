package com.smalaca.shipment.fakeapigateway.infrastructure.shipment.rest;

public class ShipmentOfferDto {
    private String id;
    private Distance distance;
    private Price price;
    private String truckId;
    private String warehouseId;

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

    public String getWarehouseId() {
        return warehouseId;
    }
}
