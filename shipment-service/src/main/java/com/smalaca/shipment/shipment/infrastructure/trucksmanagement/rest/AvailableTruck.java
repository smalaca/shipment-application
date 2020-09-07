package com.smalaca.shipment.shipment.infrastructure.trucksmanagement.rest;

import java.time.LocalDate;

public class AvailableTruck {
    private String id;
    private LocalDate start;
    private LocalDate end;

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
