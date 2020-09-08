package com.smalaca.shipment.shipment.infrastructure.historyregistry.rest;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ShipmentOfferParameters {
    private final String startPoint;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate startDate;

    private final String endPoint;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDate endDate;

    public ShipmentOfferParameters(String startPoint, LocalDate startDate, String endPoint, LocalDate endDate) {
        this.startPoint = startPoint;
        this.startDate = startDate;
        this.endPoint = endPoint;
        this.endDate = endDate;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
