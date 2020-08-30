package com.abc.demo.mq.receiver;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private final CountDownLatch latch = new CountDownLatch(1);

    private String message;

    public void receiveMessage(String message) {
        System.out.println("Received message:" + message);
        this.message = message;
        latch.countDown();
    }

    public String getMessage() {
        return message;
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}