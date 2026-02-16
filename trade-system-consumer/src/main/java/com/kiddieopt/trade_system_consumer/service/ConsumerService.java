package com.kiddieopt.trade_system_consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kiddieopt.trade_system_consumer.model.ConsumerModel;

@Service
public class ConsumerService {

    private String message;

    @KafkaListener(topics = "tradeSystem-v2", groupId = "trade-group-v2")
    public void consume(ConsumerModel consumerModel){
        message = consumerModel + "Got data from kafka";
        System.out.println(message);
    }

    public String getMessage(){
        return message;
    }
}
