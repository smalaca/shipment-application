package com.smalaca.shipment.fakeapigateway.infrastructure.web.api.order;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
class OrderController {

    @PostMapping
    public void order(@RequestBody OrderDto order) {
        System.out.println(order);
    }
}
