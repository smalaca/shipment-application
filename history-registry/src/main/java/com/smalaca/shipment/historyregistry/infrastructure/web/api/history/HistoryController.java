package com.smalaca.shipment.historyregistry.infrastructure.web.api.history;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryController {
    @PostMapping("/offer")
    public void requestOffer(@RequestBody ShipmentOfferParametersDto dto) {
        System.out.println("ShipmentOfferParametersDto received: " +
                dto.getStartPoint() + ", " +
                dto.getStartDate() + ", " +
                dto.getEndPoint() + ", " +
                dto.getEndDate());
    }
}
