package com.ppra.interview.rabbitmqdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    private final MessageProducer messageProducer;
    public MessageController(MessageProducer messageProducer){
        this.messageProducer=messageProducer;
    }
    @PostMapping("/send")
    public ResponseEntity<String>sendMessage(@RequestBody String message){
        messageProducer.sendMessage(message);
        return ResponseEntity.accepted().body("message submitted to RabbitMq");

    }
}
