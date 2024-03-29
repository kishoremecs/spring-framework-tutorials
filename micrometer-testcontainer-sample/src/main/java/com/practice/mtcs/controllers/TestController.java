package com.practice.mtcs.controllers;

import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/hello")
    @Observed(contextualName = "hello-api", name="hello-api-call")
    public String hello(){
        log.info("Say Hello loudly along with trace Id");

        ResponseEntity<String> clientResponse = restTemplate.exchange("http://localhost:7070/client-hello", HttpMethod.GET, null, String.class);
        log.info("Received response {}", clientResponse.getBody());
        return "Hi! Hello" + clientResponse.getBody();

    }
}