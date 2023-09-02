package com.spring.boot.apptesting.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/app/message")
    public String helloMessage() {
        return "Hello Users!!!";
    }
}
