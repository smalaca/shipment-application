package com.smalaca.shipment.shipment.infrastructure.web.api.offer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.smalaca.shipment.shipment.infrastructure.web.api.offer.ShipmentOfferDto.Builder.shipmentOfferDto;
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
        return asList(
                shipmentOfferDto(id)
                        .withDistance(100.5, "KM")
                        .withPrice(200.50, "USD")
                        .withTruckId("truck1")
                        .withWarehouseId("warehouse1")
                        .build(),
                shipmentOfferDto(id)
                        .withDistance(1000.5, "KM")
                        .withPrice(231.50, "EUR")
                        .withTruckId("truck2")
                        .withWarehouseId("warehouse13")
                        .build());
    }

}
