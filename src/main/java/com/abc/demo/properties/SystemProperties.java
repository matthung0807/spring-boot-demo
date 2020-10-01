package com.abc.demo.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "system")
public class SystemProperties {

    private String name;    // system.name
    private String version; // system.version
    private String url;     // system.url
    private String port;    // system.port

}
