package com.kafka.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageProducerService {

    @Value("${kafka.topic.name}")
    private String topic1;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void produceMessage(String message) {
        kafkaTemplate.send(topic1, message);
        log.info("Message has been send :: {}", message);
    }
}
