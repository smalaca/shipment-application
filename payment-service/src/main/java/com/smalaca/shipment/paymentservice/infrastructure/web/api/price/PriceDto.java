package com.smalaca.shipment.paymentservice.infrastructure.web.api.price;

class PriceDto {
    private final double amount;
    private final String currency;

    PriceDto(double amount, String currency) {
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
