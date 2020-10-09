package com.abc.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@ConditionalOnProperty(
        value = "scheduling.enabled", // 讀取application.properties的scheduling.enabled的值
        havingValue = "true", // scheduling.enabled為true則套用下面的annotation即@EnableScheduling的效果，反之@EnableScheduling會無效果
        matchIfMissing = false // default, 若scheduling.enabled沒設定則預設為false
)
@EnableScheduling
@Configuration
public class SchedulingConfig {
}
