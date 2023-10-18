package com.spring.boot.apptesting.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController

public class UUIDController {

    @GetMapping(path="/randomId", produces = {"application/json"})
    public Map<String, Object> randomIdGenerator() {
        Map<String, Object> idMap = new HashMap<>();
        idMap.put("id", UUID.randomUUID().toString());
        return idMap;
    }
}
