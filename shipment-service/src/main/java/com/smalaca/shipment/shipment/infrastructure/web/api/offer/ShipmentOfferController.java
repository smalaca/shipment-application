package com.smalaca.shipment.shipment.infrastructure.web.api.offer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/offer")
public class ShipmentOfferController {

    @PostMapping
    public String requestShipmentsOffer() {
        return UUID.randomUUID().toString();
    }

    @GetMapping("/{id}")
    public List<ShipmentOfferDto> getShipmentsOffer(@PathVariable String id) {
        return asList(new ShipmentOfferDto(id, "name of item"), new ShipmentOfferDto("abc", "another item"));
    }
}
