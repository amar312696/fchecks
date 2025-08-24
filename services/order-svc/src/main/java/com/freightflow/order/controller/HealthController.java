package com.freightflow.order.controller;


import com.freightflow.order.service.OrderService;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HealthController {
    Logger logger= LoggerFactory.getLogger(HealthController.class);
    private final OrderService orderService;

    public HealthController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/health")
    public String healthCheck(){
        return "order all ok";
    }


    @GetMapping("/kafka")
    public ResponseEntity<String> createOrder() {
        logger.info("Received request to create order via /kafka endpoint.");
        orderService.createOrder();
        return ResponseEntity.ok("Order created and event published!");
    }
}
