package com.smalaca.shipment.trucksmanagement.infrastructure.web.api.truck;

import org.apache.commons.lang3.RandomUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/truck/available")
public class AvailableTruckController {
    @GetMapping
    public List<AvailableTruckDto> findAll(
            @RequestParam String startPoint, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam String endPoint, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return IntStream.range(1, RandomUtils.nextInt(1, 5))
                .mapToObj(integer -> availableTruckDto(startDate, endDate))
                .collect(toList());
    }

    private AvailableTruckDto availableTruckDto(LocalDate startDate, LocalDate endDate) {
        return new AvailableTruckDto(randomId(), startDate.plusDays(RandomUtils.nextInt(0, 2)), endDate.minusDays(RandomUtils.nextInt(0, 2)));
    }

    private String randomId() {
        return "truck_" + UUID.randomUUID().toString();
    }
}
