package com.kiddieopt.trade_system_consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kiddieopt.trade_system_consumer.entity.TradeEntity;
import com.kiddieopt.trade_system_consumer.model.ConsumerModel;
import com.kiddieopt.trade_system_consumer.repository.TradeRepository;

@Service
public class ConsumerService {

    private static final Logger log =
            LoggerFactory.getLogger(ConsumerService.class);

    private final TradeRepository tradeRepository;

    public ConsumerService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @Transactional
    @KafkaListener(topics = "tradeSystem-v4", groupId = "trade-group-v4")
    public void consume(ConsumerModel consumerModel) {

        try {
            TradeEntity entity = new TradeEntity();
            entity.setEventId(consumerModel.getEventId());
            entity.setTradeId(consumerModel.getTradeId());
            entity.setSide(consumerModel.getSide());
            entity.setSource(consumerModel.getSource());
            entity.setQuantity(consumerModel.getQuantity());
            entity.setPrice(consumerModel.getPrice());
            entity.setTradeTimestamp(consumerModel.getTradeTimestamp());
            entity.setProcessedFlag(false);

            tradeRepository.save(entity);

            log.debug("Trade stored successfully. tradeId={}, eventId={}",
                    entity.getTradeId(),
                    entity.getEventId());

        } catch (Exception ex) {
            log.error("Failed to process Kafka message. eventId={}",
                    consumerModel.getEventId(), ex);
            throw ex; // Important → allows Kafka retry
        }
    }

    public long getTradeCount() {
        return tradeRepository.count();
    }
}