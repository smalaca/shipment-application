package com.smalaca.shipment.distancecalculator.infrastructure.web.api.distance;

class DistanceDto {
    private final double length;
    private final String metric;

    DistanceDto(double length, String metric) {
        this.length = length;
        this.metric = metric;
    }

    public double getLength() {
        return length;
    }

    public String getMetric() {
        return metric;
    }
}
