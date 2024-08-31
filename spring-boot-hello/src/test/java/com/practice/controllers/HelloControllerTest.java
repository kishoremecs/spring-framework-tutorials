package com.practice.controllers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello() throws Exception {
        mvc.perform(get("/hello?name=Kishore"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"));
    }

    @Test
    public void helloWithName() throws Exception {
        mvc.perform(get("/hello?name=Kishore"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attributeExists("user"))
                .andExpect(model().attribute("user","Kishore"));
    }
}
