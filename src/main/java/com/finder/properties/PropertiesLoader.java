package com.finder.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class PropertiesLoader {
    @Value("${itunes.client.url}")
    private String urlItunes;

    @Value("${limit}")
    private String limit;
}
