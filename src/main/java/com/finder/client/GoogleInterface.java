package com.finder.client;

import com.finder.model.google.GoogleResponse;
import io.micrometer.core.annotation.Timed;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Timed
@FeignClient(url = "${google.client.url}", name = "google-client-service")
public interface GoogleInterface {
     @GetMapping
     GoogleResponse getBooks(@RequestParam(value = "q") String reference,
                             @RequestParam(value = "maxResults") String maxResult);

}
