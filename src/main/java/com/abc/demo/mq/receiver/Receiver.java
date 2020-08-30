package com.abc.demo.mq.receiver;

import com.abc.demo.mq.config.RabbitMqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private String message;

    @RabbitListener(queues = RabbitMqConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("Received message:" + message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}