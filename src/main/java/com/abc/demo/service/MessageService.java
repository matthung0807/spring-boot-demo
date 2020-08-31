package com.abc.demo.service;

import com.abc.demo.mq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final RabbitTemplate rabbitTemplate;

    public MessageService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String message) throws Exception {
        System.out.println("Sending message:" + message);
        rabbitTemplate.convertAndSend(
                RabbitMqConfig.TOPIC_EXCHANGE_NAME,
                RabbitMqConfig.ROUTING_KEY,
                message);
    }
}
