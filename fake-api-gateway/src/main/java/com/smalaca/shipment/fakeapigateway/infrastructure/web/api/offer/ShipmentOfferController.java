package com.smalaca.shipment.fakeapigateway.infrastructure.web.api.offer;

import com.smalaca.shipment.fakeapigateway.infrastructure.shipment.rest.ShipmentClient;
import com.smalaca.shipment.fakeapigateway.infrastructure.shipment.rest.ShipmentOfferDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offer")
public class ShipmentOfferController {
    private final ShipmentClient shipmentClient;

    public ShipmentOfferController(ShipmentClient shipmentClient) {
        this.shipmentClient = shipmentClient;
    }

    @PostMapping
    public String requestShipmentsOffer() {
        return shipmentClient.requestShipmentOffer();
    }

    @GetMapping("/{id}")
    public List<ShipmentOfferDto> getShipmentsOffer(@PathVariable String id) {
        return shipmentClient.getShipmentOffer(id);
    }
}
