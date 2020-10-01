package com.abc.demo.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "system")
public class SystemProperties {

    /** System Name */
    private String name;    // system.name
    /** System Versoin */
    private String version; // system.version
    private String url;     // system.url
    private String port;    // system.port

}
