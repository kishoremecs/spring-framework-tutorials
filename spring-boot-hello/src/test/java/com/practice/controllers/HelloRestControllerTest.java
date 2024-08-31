package com.practice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerTest {

    @Test
    public void autowiringWorked(@LocalServerPort int port) {
        assertNotNull(port);
        System.out.println("Port: " + port);
    }

    @Test
    public void testHello(@Autowired TestRestTemplate webTestClient) {
        var greeting = webTestClient.getForObject("/greet?name={name}", Greeting.class, "Kishore");
        assertEquals("Hello, Kishore!", greeting.message());
    }
}
