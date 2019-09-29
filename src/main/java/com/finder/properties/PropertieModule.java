package com.finder.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class PropertieModule {
    @Bean
    public PropertiesLoader propertiesLoader() {
            return new PropertiesLoader();
        }
}
