package com.smalaca.shipment.fakeapigateway.infrastructure.rest.offer;

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
public class OfferController {

    @PostMapping
    public String hello() {
        return "Hello world " + UUID.randomUUID().toString();
    }

    @GetMapping("/{id}")
    public List<OfferDto> getShipments(@PathVariable String id) {
        return asList(new OfferDto(id, "name of item"), new OfferDto("abc", "another item"));
    }
}
