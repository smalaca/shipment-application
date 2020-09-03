package com.smalaca.shipment.shipment.infrastructure.web.api.offer;

class Price {
    private final double amount;
    private final String currency;

    Price(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
