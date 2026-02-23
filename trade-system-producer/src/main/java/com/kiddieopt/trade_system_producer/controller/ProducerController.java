package com.kiddieopt.trade_system_producer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiddieopt.trade_system_producer.model.ProducerModel;
import com.kiddieopt.trade_system_producer.service.ProducerService;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/kafka")
public class ProducerController {

    private static final Logger log =
            LoggerFactory.getLogger(ProducerController.class);

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/add-trade")
    public ResponseEntity<String> addTrade(@RequestBody ProducerModel producerModel) {

        try {
            String response = producerService.sendMessage(producerModel);

            log.info("Trade message sent. tradeId={}", producerModel.getTradeId());

            return ResponseEntity.ok(response);

        } catch (Exception ex) {
            log.error("Failed to send trade message. tradeId={}",
                    producerModel.getTradeId(), ex);

            return ResponseEntity.internalServerError()
                    .body("Failed to send trade message");
        }
    }
}