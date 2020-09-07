package com.smalaca.shipment.warehousemanagement.infrastructure.web.api.warehouse;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/warehouse/available")
public class AvailableWarehouseController {
    @GetMapping
    public WarehouseDto getAvailable(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return new WarehouseDto(randomId());
    }

    private String randomId() {
        return "warehouse_" + UUID.randomUUID().toString();
    }
}
