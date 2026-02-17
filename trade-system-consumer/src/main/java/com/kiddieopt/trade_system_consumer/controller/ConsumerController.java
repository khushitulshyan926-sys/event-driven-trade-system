package com.kiddieopt.trade_system_consumer.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiddieopt.trade_system_consumer.service.ConsumerService;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/kafka")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> getTradeCount(){
        long response = consumerService.getTradeCount();
        return ResponseEntity.ok(Map.of("tradeCount", response));
}

}

