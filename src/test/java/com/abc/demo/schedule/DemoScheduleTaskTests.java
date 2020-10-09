package com.abc.demo.schedule;

import org.awaitility.Awaitility;
import org.awaitility.Durations;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("prod")
@SpringBootTest
class DemoScheduleTaskTests {

    private final static int MIN_NUMBER_OF_INVOCATIONS = 2;

    @SpyBean // 用@SpyBean才可被Mockito.verify驗證備測試對象的調用次數
    private DemoScheduleTask demoScheduleTask;

    /**
     * 測試DemoScheduleTask.printUnixEpochTime()在10秒鐘至少被執行2次
     */
    @Test
    void printUnixEpochTime_testInvocationAtLeastTwoTimesDuringTenSeconds() {
        Awaitility.await()
                .atMost(Durations.TEN_SECONDS) // 等待期間10秒
                .untilAsserted( // 直到assert發生停止等待
                        () -> Mockito.verify(demoScheduleTask, Mockito.atLeast(MIN_NUMBER_OF_INVOCATIONS))
                                .printUnixEpochTime()); // 驗證demoScheduleTask.printUnixEpochTime()被調用2次
    }
}
