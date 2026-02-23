package com.kiddieopt.trade_system_consumer.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiddieopt.trade_system_consumer.service.ConsumerService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/kafka")
public class ConsumerController {

    private static final Logger log =
            LoggerFactory.getLogger(ConsumerController.class);

    private final ConsumerService consumerService;

    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> getTradeCount() {

        long count = consumerService.getTradeCount();

        log.debug("Fetched trade count: {}", count);

        return ResponseEntity.ok(Map.of("tradeCount", count));
    }
}