package com.smalaca.shipment.warehousemanagement.infrastructure.web.api.warehouse;

public class WarehouseDto {
    private final String id;

    public WarehouseDto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
