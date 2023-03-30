package com.example.rabbitMQ.controller;

import com.example.rabbitMQ.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    private RabbitMQProducer producer;

    public MessageController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @GetMapping("/publisher")
    public ResponseEntity<String> sendMessage(@RequestParam String message){
        producer.sendMessage(message);
        return ResponseEntity.ok("Message send to RabbitMQ");
    }
}
