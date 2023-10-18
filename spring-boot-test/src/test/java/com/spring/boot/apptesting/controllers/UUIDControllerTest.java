package com.spring.boot.apptesting.controllers;

import org.apache.coyote.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UUIDControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;



    @Test
    public void randomIdGenerator() {
        ResponseEntity<Map> randomIDResponse = testRestTemplate.getForEntity("/randomId", Map.class);
        System.out.println(randomIDResponse);
        Assertions.assertNotNull(randomIDResponse);
    }
}
