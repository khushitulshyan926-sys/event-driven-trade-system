package com.kiddieopt.trade_system_consumer.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "tradedb")
public class TradeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //primary key for db

    private String eventId; //uuid for unique event
    private String tradeId; //tradeID for bussiness logic
    private String side; //Buy/Sell
    private String source;
    private Integer quantity;

    private Double price;

    private LocalDateTime tradeTimestamp;
    private LocalDateTime eventCreatedAt;

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getTradeTimestamp() {
        return tradeTimestamp;
    }

    public void setTradeTimestamp(LocalDateTime tradeTimestamp) {
        this.tradeTimestamp = tradeTimestamp;
    }

    public LocalDateTime getEventCreatedAt() {
        return eventCreatedAt;
    }

    public void setEventCreatedAt(LocalDateTime eventCreatedAt) {
        this.eventCreatedAt = eventCreatedAt;
    }

    
}

