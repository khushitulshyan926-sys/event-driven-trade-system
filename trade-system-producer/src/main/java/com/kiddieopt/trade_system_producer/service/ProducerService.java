package com.kiddieopt.trade_system_producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kiddieopt.trade_system_producer.model.ProducerModel;

@Service
public class ProducerService {

    private static final Logger log =
            LoggerFactory.getLogger(ProducerService.class);

    private final KafkaTemplate<String, ProducerModel> kafkaTemplate;

    public ProducerService(KafkaTemplate<String, ProducerModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(ProducerModel producerModel) {

        try {
            kafkaTemplate.send(
                    "tradeSystem-v4",
                    producerModel.getTradeId(),
                    producerModel
            );

            log.info("Message published to Kafka. tradeId={}",
                    producerModel.getTradeId());

            return "Message sent to Kafka successfully";

        } catch (Exception ex) {
            log.error("Failed to publish message. tradeId={}",
                    producerModel.getTradeId(), ex);
            throw ex;
        }
    }
}