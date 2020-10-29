package com.abc.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "demo")
public class ConfigServerDemoProperties {

    private final String env;

    public ConfigServerDemoProperties(String env) {
        this.env = env;
    }

    public String getEnv() {
        return env;
    }
}
