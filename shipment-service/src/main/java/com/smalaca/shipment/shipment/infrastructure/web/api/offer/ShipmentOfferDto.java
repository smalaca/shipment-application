package com.smalaca.shipment.shipment.infrastructure.web.api.offer;

class ShipmentOfferDto {
    private final String id;
    private final Distance distance;
    private final Price price;
    private final String truckId;
    private final String warehouseId;

    public ShipmentOfferDto(Builder builder) {
        id = builder.id;
        distance = builder.distance;
        price = builder.price;
        truckId = builder.truckId;
        warehouseId = builder.warehouseId;
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

    public String getWarehouseId() {
        return warehouseId;
    }

    public static class Builder {
        private final String id;
        private Distance distance;
        private Price price;
        private String truckId;
        private String warehouseId;

        private Builder(String id) {
            this.id = id;
        }

        static Builder shipmentOfferDto(String id) {
            return new Builder(id);
        }

        Builder withDistance(double amount, String metric) {
            distance = new Distance(amount, metric);
            return this;
        }

        Builder withPrice(double amount, String currency) {
            price = new Price(amount, currency);
            return this;
        }

        Builder withTruckId(String truckId) {
            this.truckId = truckId;
            return this;
        }

        Builder withWarehouseId(String warehouseId) {
            this.warehouseId = warehouseId;
            return this;
        }

        ShipmentOfferDto build() {
            return new ShipmentOfferDto(this);
        }
    }
}
