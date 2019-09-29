package com.finder.client;

import com.finder.model.google.GoogleResponse;
import com.finder.properties.PropertiesLoader;
import org.springframework.stereotype.Component;

@Component
public class GoogleClient {

    private GoogleInterface googleInterface;
    private PropertiesLoader propertiesLoader;

    public GoogleClient(GoogleInterface googleInterface, PropertiesLoader propertiesLoader) {
        this.googleInterface = googleInterface;
        this.propertiesLoader = propertiesLoader;
    }

    public GoogleResponse findBooks(String reference){
        return googleInterface.getBooks(reference, propertiesLoader.getLimit());
    }
}
