package com.abc.demo.schedule;

import org.awaitility.Awaitility;
import org.awaitility.Durations;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

@SpringBootTest
class DemoScheduleTaskTests {

    private final static int MIN_NUMBER_OF_INVOCATIONS = 2;

    @SpyBean
    DemoScheduleTask demoScheduleTask;

    /**
     * 測試DemoScheduleTask.printUnixEpochTime()在10秒鐘至少被執行2次
     */
    @Test
    void printUnixEpochTime_testInvocationAtLeastTwoTimesDuringTenSeconds() {
        Awaitility.await().atMost(Durations.TEN_SECONDS).untilAsserted(
                () -> Mockito.verify(demoScheduleTask, Mockito.atLeast(MIN_NUMBER_OF_INVOCATIONS)).printUnixEpochTime());
    }
}
