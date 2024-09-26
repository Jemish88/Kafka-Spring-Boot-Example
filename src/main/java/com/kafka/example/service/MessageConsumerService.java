package com.kafka.example.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumerService {
    @KafkaListener(topics = "test-topic", groupId = "my-group-id")
    public void listen(String message) {
        System.out.println("Received Message : " + message);
    }
}
