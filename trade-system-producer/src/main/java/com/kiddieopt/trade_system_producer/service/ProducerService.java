package com.kiddieopt.trade_system_producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kiddieopt.trade_system_producer.model.ProducerModel;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, ProducerModel> kafkaTemplate;

    public String sendMessage(ProducerModel producerModel){
        kafkaTemplate.send("tradeSystem-v2", "producerModel", producerModel);
        return "message sent to kafka server";
    }

}
