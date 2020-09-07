package com.smalaca.shipment.trucksmanagement.infrastructure.web.api.truck;

import java.time.LocalDate;

class AvailableTruckDto {
    private final String id;
    private final LocalDate start;
    private final LocalDate end;

    AvailableTruckDto(String id, LocalDate start, LocalDate end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }

    public String getId() {
        return id;
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getEnd() {
        return end;
    }
}
