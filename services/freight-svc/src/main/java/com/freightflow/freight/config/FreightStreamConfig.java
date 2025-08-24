package com.freightflow.freight.config;


import com.freightflow.events.OrderCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.constant.Constable;
import java.util.function.Consumer;

@Configuration
public class FreightStreamConfig {
    Logger log = LoggerFactory.getLogger(FreightStreamConfig.class);

    @Bean
    public Consumer<OrderCreatedEvent> orderCreatedConsumer(){

        return event->{
            try{
                log.info("🚚 Freight service received: {}",event);

            }catch (Exception e) {
                log.error("Error processing OrderCreatedEvent: {}", e.getMessage(), e);
            }
        };
    }
}
