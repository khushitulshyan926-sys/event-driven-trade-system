package com.kiddieopt.trade_system_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiddieopt.trade_system_producer.model.ProducerModel;
import com.kiddieopt.trade_system_producer.service.ProducerService;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    ProducerService producerService;

    @PostMapping("/add-trade")    
    public ResponseEntity<String> addTrade(@RequestBody ProducerModel producerModel){
        String response = producerService.sendMessage(producerModel);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
