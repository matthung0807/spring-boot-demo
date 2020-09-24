package com.abc.demo.properties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@ConstructorBinding
@ConfigurationProperties(prefix = "system")
public class SystemProperties {

    private final String name;    // system.name
    private final String version; // system.version
    private final String url;     // system.url
    private final String port;    // system.port

    public SystemProperties(
            String name,
            String version,
            String url,
            String port) {
        this.name = name;
        this.version = version;
        this.url = url;
        this.port = port;
    }

}
