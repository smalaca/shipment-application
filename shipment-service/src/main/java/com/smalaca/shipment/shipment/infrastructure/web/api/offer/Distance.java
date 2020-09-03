package com.smalaca.shipment.shipment.infrastructure.web.api.offer;

class Distance {
    private final double amount;
    private final String metric;

    Distance(double amount, String metric) {
        this.amount = amount;
        this.metric = metric;
    }

    public double getAmount() {
        return amount;
    }

    public String getMetric() {
        return metric;
    }
}
