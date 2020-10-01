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

    private String name;    // system.name
    private String version; // system.version
    private String url;     // system.url
    private String port;    // system.port

    private Map<String, String> keyMap; // {key2=value2;, key1=value1}

    @NestedConfigurationProperty
    private Admin admin; // system.admin

    @Getter
    @Setter
    public static class Admin {

        private String username; // system.admin.username
        private String password; // system.admin.password
        private List<String> schemas; // system.admin.schemas

    }

}
