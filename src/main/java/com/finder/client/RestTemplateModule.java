package com.finder.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateModule {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate client = new RestTemplate();
        return client;
    }
}
