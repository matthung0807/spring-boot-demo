package com.abc.demo.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "system")
public class SystemProperties {

    private String name;    // system.name (system.yaml)
    private String version; // system.version (system.yaml)
    private String url;     // system.url (system.properties)
    private String port;    // system.port (system.properties)

}
