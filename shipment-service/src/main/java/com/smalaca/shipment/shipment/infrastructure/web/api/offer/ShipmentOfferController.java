package com.smalaca.shipment.shipment.infrastructure.web.api.offer;

import com.smalaca.shipment.shipment.infrastructure.distancecalculator.rest.Distance;
import com.smalaca.shipment.shipment.infrastructure.distancecalculator.rest.DistanceCalculatorClient;
import com.smalaca.shipment.shipment.infrastructure.paymentservice.rest.PaymentServiceClient;
import com.smalaca.shipment.shipment.infrastructure.paymentservice.rest.Price;
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
    private final DistanceCalculatorClient distanceCalculatorClient;
    private final PaymentServiceClient paymentServiceClient;

    public ShipmentOfferController(DistanceCalculatorClient distanceCalculatorClient, PaymentServiceClient paymentServiceClient) {
        this.distanceCalculatorClient = distanceCalculatorClient;
        this.paymentServiceClient = paymentServiceClient;
    }

    @PostMapping
    public String requestShipmentsOffer() {
        return UUID.randomUUID().toString();
    }

    @GetMapping("/{id}")
    public List<ShipmentOfferDto> getShipmentsOffer(@PathVariable String id) {
        return asList(offer1(id), offer2(id));
    }

    private ShipmentOfferDto offer1(String id) {
        Distance distance = distanceCalculatorClient.calculate("start", "end");

        return shipmentOfferDto(id)
                .withDistance(distance)
                .withPrice(priceFor(distance, "truck1", "warehouse1"))
                .withTruckId("truck1")
                .withWarehouseId("warehouse1")
                .build();
    }

    private ShipmentOfferDto offer2(String id) {
        Distance distance = distanceCalculatorClient.calculate("start", "end");
        return shipmentOfferDto(id)
                .withDistance(distance)
                .withPrice(priceFor(distance, "truck2", "warehouse13"))
                .withTruckId("truck2")
                .withWarehouseId("warehouse13")
                .build();
    }

    private Price priceFor(Distance distance, String truckId, String warehouseId) {
        return paymentServiceClient.calculateFor(distance.getLength(), distance.getMetric(), truckId, warehouseId);
    }

}
