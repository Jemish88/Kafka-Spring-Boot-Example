package com.kafka.example.controller;

import com.kafka.example.service.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private MessageProducerService messageProducerService;

    @GetMapping("/send")
    public String sendMessage(@RequestParam(value = "message") String message) {
        messageProducerService.produceMessage("test-topic", message);
        return "OK";
    }
}
