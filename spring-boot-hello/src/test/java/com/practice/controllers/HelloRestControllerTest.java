package com.practice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerTest {

    @Test
    public void testHello(@Autowired TestRestTemplate webTestClient) {
        String body = webTestClient.getForObject("/greet?name={name}", String.class, "Kishore");
        assertEquals("{\"message\":\"Hello, Kishore!\"}", body);
    }
}
