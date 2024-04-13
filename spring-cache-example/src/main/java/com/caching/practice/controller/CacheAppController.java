package com.caching.practice.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CacheAppController {

    @GetMapping("/getUniqueIdentifier/{customerName}")
    @Cacheable("unique")
    public String getUniqueIdentifier(@PathVariable("customerName") String customerName) {
        System.out.println("Executing for uuid");
        return UUID.randomUUID().toString();
    }

}
