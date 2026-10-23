package com.ppra.interview.rabbitmqdemo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
    private  final RabbitTemplate rabbitTemplate;
    public MessageProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate=rabbitTemplate;
    }
    public void sendMessage(String message){
        rabbitTemplate.convertAndSend(RabitConfig.EXCHANGE,RabitConfig.ROUTING_KEY,message);
    }
}
