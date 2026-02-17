package com.kiddieopt.trade_system_consumer.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ConsumerModel {

    private String eventId;
    private String tradeId;
    private String side; //Buy/Sell
    private String source;
    private Integer quantity;

    private Double price;

    private LocalDateTime tradeTimestamp;
    private LocalDateTime eventCreatedAt;

    public ConsumerModel() {}

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

    @Override
    public String toString(){
        return "Trade [eventId=" + eventId + ", tradeId=" +tradeId+ ", side=" +side+ ", source=" +source+ ", quntity=" +quantity+", price="+price+", tradetime=" +tradeTimestamp+", event created at="+eventCreatedAt+"]";
    }
}
