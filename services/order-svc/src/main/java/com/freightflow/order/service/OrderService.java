package com.freightflow.order.service;

import com.freightflow.events.OrderCreatedEvent;
import lombok.NoArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service

public class OrderService {

    private final StreamBridge streamBridge;
    Logger logger= LoggerFactory.getLogger(OrderService.class);

    public OrderService(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void createOrder() {
        OrderCreatedEvent orderEvent = new OrderCreatedEvent(
                UUID.randomUUID().toString(),
                "CUST-123",
                "New York",
                "San Francisco",
                Instant.now()
        );

//        Message<OrderCreatedEvent> message = MessageBuilder.withPayload(event)
//                .setHeader("spring.cloud.stream.function.streamBridge.contentType", "application/json")
//                .setHeader("spring_json_header", event.getClass().getName())
//                .build();

        logger.info("orderEvent in order-svc {}",orderEvent);

        streamBridge.send("orderCreatedProducer-out-0", orderEvent);
    }
}
