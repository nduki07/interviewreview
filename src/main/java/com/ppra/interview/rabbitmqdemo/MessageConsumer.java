package com.ppra.interview.rabbitmqdemo;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import reactor.util.concurrent.Queues;

@Service
public class MessageConsumer {
    @RabbitListener(queues = RabitConfig.QUEUE)
    public void receiveMessage(String message){
        System.out.println("message received " + message);
    }

}
