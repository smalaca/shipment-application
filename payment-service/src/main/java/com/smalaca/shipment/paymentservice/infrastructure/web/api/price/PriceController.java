package com.smalaca.shipment.paymentservice.infrastructure.web.api.price;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/price")
public class PriceController {
    private static final List<String> CURRENCIES = ImmutableList.of("USD", "EUR", "PLN");

    @GetMapping
    public PriceDto calculatePrice(@RequestParam double length, @RequestParam String metric, @RequestParam String truckId, @RequestParam String warehouseId) {
        return new PriceDto(randomAmount(), randomCurrency());
    }

    private double randomAmount() {
        return RandomUtils.nextInt(1000, 1000000);
    }

    private String randomCurrency() {
        return CURRENCIES.get(RandomUtils.nextInt(0, 3));
    }
}
