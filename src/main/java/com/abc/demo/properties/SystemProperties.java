package com.abc.demo.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.List;
import java.util.Map;

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

    private Map<String, String> keyMap;

    @NestedConfigurationProperty
    private Admin admin;

    @Getter
    @Setter
    public static class Admin {

        private String username;
        private String password;
        private List<String> schemas;

    }

}
