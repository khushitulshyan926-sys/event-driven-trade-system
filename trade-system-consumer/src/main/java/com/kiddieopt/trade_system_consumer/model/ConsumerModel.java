package com.kiddieopt.trade_system_consumer.model;

import java.time.LocalDate;

public class ConsumerModel {

    private String eventId;
    private String tradeId;
    private String source;

    private Double price;

    private LocalDate tradeDate;

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    @Override
    public String toString(){
        return "Trade [eventId=" + eventId + ", tradeId=" +tradeId+ ", source=" +source+ ", price="+price+", tradeDate=" +tradeDate+"]";
    }
}
