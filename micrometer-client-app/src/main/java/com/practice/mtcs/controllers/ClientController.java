package com.practice.mtcs.controllers;

import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ClientController {

    @GetMapping("/client-hello")
    @Observed(contextualName = "client-hello-api", name="hello-api-call")
    public String hello(){
        log.info("Say Hello loudly along with trace Id from Client");
        return "Hi! Hello , In Client";
    }
}