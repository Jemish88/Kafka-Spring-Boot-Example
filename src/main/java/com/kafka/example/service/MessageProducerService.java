package com.kafka.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void produceMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
