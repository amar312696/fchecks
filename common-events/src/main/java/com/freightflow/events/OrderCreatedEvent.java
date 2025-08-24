package com.freightflow.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

//@Data
//@NoArgsConstructor
public class OrderCreatedEvent{
//    private static final long serialVersionUID = 1L;

    private String orderId;
    private String customerId;
    private String origin;
    private String destination;
    private Instant createdAt;


    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(String orderId, String customerId, String origin, String destination, Instant createdAt) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.origin = origin;
        this.destination = destination;
        this.createdAt = createdAt;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        OrderCreatedEvent event = (OrderCreatedEvent) o;
        return orderId.equals(event.orderId) && customerId.equals(event.customerId) && origin.equals(event.origin) && destination.equals(event.destination) && createdAt.equals(event.createdAt);
    }

    @Override
    public int hashCode() {
        int result = orderId.hashCode();
        result = 31 * result + customerId.hashCode();
        result = 31 * result + origin.hashCode();
        result = 31 * result + destination.hashCode();
        result = 31 * result + createdAt.hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "OrderCreatedEvent{" +
                "orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
