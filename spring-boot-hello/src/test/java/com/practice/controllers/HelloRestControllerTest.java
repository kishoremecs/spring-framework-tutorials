package com.practice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import java.util.Objects;

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

    @Test
    public void greetWithName(@Autowired TestRestTemplate webTestClient) {
        var greeting = webTestClient.getForEntity("/greet?name={name}", Greeting.class, "Kishore");
        assertEquals("Hello, Kishore!", Objects.requireNonNull(greeting.getBody()).message());
        assertTrue(greeting.getStatusCode().is2xxSuccessful());
        assertEquals(MediaType.APPLICATION_JSON,greeting.getHeaders().getContentType());
    }
}
