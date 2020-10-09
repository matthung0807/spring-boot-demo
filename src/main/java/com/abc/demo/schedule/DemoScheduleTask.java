package com.abc.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoScheduleTask {

    @Scheduled(fixedRate = 3000)
    public void printUnixEpochTime() {
        System.out.println(System.currentTimeMillis());
    }

}
