package com.finder.client;

import com.finder.model.itunes.ItunesResponse;
import com.finder.properties.PropertiesLoader;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ItunesClient {

    private RestTemplate restTemplate;
    private PropertiesLoader propertiesLoader;

    public ItunesClient(RestTemplate restTemplate, PropertiesLoader propertiesLoader, MeterRegistry registry) {
        this.restTemplate = restTemplate;
        this.propertiesLoader = propertiesLoader;
    }

    public ItunesResponse findAlbums(String reference) {
        ItunesResponse itunesResponse = new ItunesResponse();
        try {

            restTemplate.setMessageConverters(setupConvertersMediaType());
            itunesResponse = restTemplate
                    .getForObject(propertiesLoader.getUrlItunes()+"?term={reference}+&entity=album&limit="
                                    +propertiesLoader.getLimit(),
                            ItunesResponse.class, reference);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return itunesResponse;
    }

    private List<HttpMessageConverter<?>> setupConvertersMediaType(){
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        return messageConverters;
    }
}
