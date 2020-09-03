package com.smalaca.shipment.distancecalculator.infrastructure.web.api.distance;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/distance")
public class DistanceController {
    private static final List<String> METRICS = ImmutableList.of("KM", "MI", "Lightyears");

    @GetMapping("/{start}/{destination}")
    public DistanceDto calculate(@PathVariable String start, @PathVariable String destination) {
        return new DistanceDto(randomLength(), randomMetric());
    }

    private double randomLength() {
        return RandomUtils.nextDouble(100, 10000);
    }

    private String randomMetric() {
        return METRICS.get(RandomUtils.nextInt(0, 3));
    }
}
