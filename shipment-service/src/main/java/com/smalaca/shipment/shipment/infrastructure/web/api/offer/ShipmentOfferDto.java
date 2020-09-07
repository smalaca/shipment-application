package com.smalaca.shipment.shipment.infrastructure.web.api.offer;

import com.smalaca.shipment.shipment.infrastructure.distancecalculator.rest.Distance;
import com.smalaca.shipment.shipment.infrastructure.paymentservice.rest.Price;

import java.util.ArrayList;
import java.util.List;

class ShipmentOfferDto {
    private final String id;
    private final Distance distance;
    private final Price price;
    private final String truckId;
    private final List<String> warehouseIds;

    private ShipmentOfferDto(Builder builder) {
        id = builder.id;
        distance = builder.distance;
        price = builder.price;
        truckId = builder.truckId;
        warehouseIds = builder.warehouseIds;
    }

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

    public static class Builder {
        private final String id;
        private Distance distance;
        private Price price;
        private String truckId;
        private final List<String> warehouseIds = new ArrayList<>();

        private Builder(String id) {
            this.id = id;
        }

        static Builder shipmentOfferDto(String id) {
            return new Builder(id);
        }

        Builder withDistance(Distance distance) {
            this.distance = distance;
            return this;
        }

        Builder withPrice(Price price) {
            this.price = price;
            return this;
        }

        Builder withTruckId(String truckId) {
            this.truckId = truckId;
            return this;
        }

        Builder addWarehouseId(String warehouseId) {
            warehouseIds.add(warehouseId);
            return this;
        }

        ShipmentOfferDto build() {
            return new ShipmentOfferDto(this);
        }
    }
}
