package com.kiddieopt.trade_system_consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kiddieopt.trade_system_consumer.entity.TradeEntity;
import com.kiddieopt.trade_system_consumer.model.ConsumerModel;
import com.kiddieopt.trade_system_consumer.repository.TradeRepository;

@Service
public class ConsumerService {

    private final TradeRepository tradeRepository;

    public ConsumerService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    @KafkaListener(topics = "tradeSystem-v4", groupId = "trade-group-v4")
    public void consume(ConsumerModel consumerModel){
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

        System.out.println("Trade stored in DB");
    }

    public long getTradeCount(){
    return tradeRepository.count();
}
}


