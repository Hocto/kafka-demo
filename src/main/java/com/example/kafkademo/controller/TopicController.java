package com.example.kafkademo.controller;

import com.example.kafkademo.service.KafkaMessageSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/topic")
@RequiredArgsConstructor
public class TopicController {

    private final KafkaMessageSender kafkaMessageSender;

    @PostMapping(path = "/send/{message}", produces = "application/json")
    public ResponseEntity<String> sendMessage(@PathVariable String message) {

        kafkaMessageSender.sendMessage(message);

        return new ResponseEntity<>(
                "Your message was sent.",
                HttpStatus.OK);
    }
}
