package com.abc.demo.schedule;

import org.awaitility.Awaitility;
import org.awaitility.Durations;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
class DemoScheduleTaskTests {

    @SpyBean
    DemoScheduleTask demoScheduleTask;

    @Test
    void printUnixEpochTime_test() {
        Awaitility.await().atMost(Durations.TEN_SECONDS).untilAsserted(
                () -> Mockito.verify(demoScheduleTask, Mockito.atLeast(2)).printUnixEpochTime());
    }
}
