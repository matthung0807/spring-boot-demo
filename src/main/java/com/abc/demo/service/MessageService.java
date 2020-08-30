package com.abc.demo.service;

import com.abc.demo.mq.config.RabbitMqConfig;
import com.abc.demo.mq.receiver.Receiver;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public MessageService(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String message) throws Exception {
        System.out.println("Sending message:" + message);
        rabbitTemplate.convertAndSend(
                RabbitMqConfig.TOPIC_EXCHANGE_NAME,
                "demo-routing-key",
                message);
    }

}
