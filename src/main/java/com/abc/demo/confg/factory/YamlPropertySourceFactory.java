package com.abc.demo.confg.factory;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

public class YamlPropertySourceFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {

        String resourceFileName = resource.getResource().getFilename();

        if (resourceFileName == null || resourceFileName.length() == 0) {
            return new DefaultPropertySourceFactory().createPropertySource(name, resource);
        }

        if (resourceFileName.endsWith("yaml") || resourceFileName.endsWith("yml")) {
            YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
            factoryBean.setResources(resource.getResource());
            Properties properties = factoryBean.getObject();

            return new PropertiesPropertySource(resourceFileName, properties);
        }

        if (resourceFileName.endsWith(".properties")) {
            return new DefaultPropertySourceFactory().createPropertySource(resourceFileName, resource);
        }

        return new DefaultPropertySourceFactory().createPropertySource(name, resource);
    }
}
