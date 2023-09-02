package com.spring.boot.apptesting.controllers;

import com.spring.boot.apptesting.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    MockMvc mvc;

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BookController bookController;

    @Test
    void findAllShouldReturnAllBooks() throws Exception {
        Assertions.assertNotNull(bookController);
        List<Book> books = bookController.findAllBooks();
        Assertions.assertNotNull(books);

        String response = this.restTemplate.getForObject("http://localhost:" + port + "/books",
                String.class);
        System.out.println(response);
        Assertions.assertTrue(response.contains("Java"));

//        mvc.perform(get("/books"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.length()").value(2));
    }

    private List<Book> getBooks() {
        Book one = new Book(1,
                "97 Things Every Java Programmer Should Know",
                "Kevlin Henney, Trisha Gee",
                "OReilly Media, Inc.",
                "May 2020",
                "9781491952696",
                "Java");
        Book two = new Book(2,
                "Spring Boot: Up and Running",
                "Mark Heckler",
                "OReilly Media, Inc.",
                "February 2021",
                "9781492076919",
                "Spring");
        Book three = new Book(3,
                "Hacking with Spring Boot 2.3: Reactive Edition",
                "Greg L. Turnquist",
                "Amazon.com Services LLC",
                "May 2020",
                "B086722L4L",
                "Spring");

        return Arrays.asList(one,two,three);
    }
}
