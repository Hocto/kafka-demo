package com.example.kafkademo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaMessageSender {

    private static final String TOPIC_NAME = "new_topic";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        log.info("Message: {}", msg);
        kafkaTemplate.send(TOPIC_NAME, msg);
    }
}
