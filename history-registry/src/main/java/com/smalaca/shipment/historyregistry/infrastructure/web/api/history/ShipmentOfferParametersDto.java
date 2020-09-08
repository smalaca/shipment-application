package com.smalaca.shipment.historyregistry.infrastructure.web.api.history;

import java.time.LocalDate;

public class ShipmentOfferParametersDto {
    private String startPoint;
    private LocalDate startDate;
    private String endPoint;
    private LocalDate endDate;

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
