package com.smalaca.shipment.shipment.infrastructure.web.api.offer;

import com.smalaca.shipment.shipment.infrastructure.distancecalculator.rest.Distance;
import com.smalaca.shipment.shipment.infrastructure.distancecalculator.rest.DistanceCalculatorClient;
import com.smalaca.shipment.shipment.infrastructure.paymentservice.rest.PaymentServiceClient;
import com.smalaca.shipment.shipment.infrastructure.paymentservice.rest.Price;
import com.smalaca.shipment.shipment.infrastructure.trucksmanagement.rest.AvailableTruck;
import com.smalaca.shipment.shipment.infrastructure.trucksmanagement.rest.TrucksManagementClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static com.smalaca.shipment.shipment.infrastructure.web.api.offer.ShipmentOfferDto.Builder.shipmentOfferDto;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/offer")
public class ShipmentOfferController {
    private final DistanceCalculatorClient distanceCalculatorClient;
    private final PaymentServiceClient paymentServiceClient;
    private final TrucksManagementClient trucksManagementClient;

    public ShipmentOfferController(
            DistanceCalculatorClient distanceCalculatorClient, PaymentServiceClient paymentServiceClient, TrucksManagementClient trucksManagementClient) {
        this.distanceCalculatorClient = distanceCalculatorClient;
        this.paymentServiceClient = paymentServiceClient;
        this.trucksManagementClient = trucksManagementClient;
    }

    @PostMapping
    public String requestShipmentsOffer() {
        return UUID.randomUUID().toString();
    }

    @GetMapping("/{id}")
    public List<ShipmentOfferDto> getShipmentsOffer(@PathVariable String id) {
        String startPoint = "pointA";
        LocalDate startDate = LocalDate.of(2020, 9, 7);
        String endPoint = "pointB";
        LocalDate endDate = LocalDate.of(2020, 9, 16);

        return trucksManagementClient.getAllAvailable(startPoint, startDate, endPoint, endDate)
                .stream()
                .map(availableTruck -> asShipmentOfferDto(id, startPoint, startDate, endPoint, endDate, availableTruck))
                .collect(toList());
    }

    private ShipmentOfferDto asShipmentOfferDto(String id, String startPoint, LocalDate startDate, String endPoint, LocalDate endDate, AvailableTruck truck) {
        Distance distance = distanceCalculatorClient.calculate(startPoint, endPoint);

        ShipmentOfferDto.Builder builder = shipmentOfferDto(id)
                .withDistance(distance)
                .withPrice(priceFor(distance, truck.getId()))
                .withTruckId(truck.getId());

        if (truck.getStart().isAfter(startDate)) {
            builder.addWarehouseId("warehouse_" + UUID.randomUUID().toString());
        }

        if (truck.getEnd().isBefore(endDate)) {
            builder.addWarehouseId("warehouse_" + UUID.randomUUID().toString());
        }

        return builder.build();
    }

    private Price priceFor(Distance distance, String truckId) {
        return paymentServiceClient.calculateFor(distance.getLength(), distance.getMetric(), truckId, "warehouse_" + UUID.randomUUID().toString());
    }
}
