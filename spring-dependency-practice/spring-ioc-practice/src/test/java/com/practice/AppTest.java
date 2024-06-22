package com.practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppTest {

    @Test
    public void add() {
        App app = new App();
        var result = app.add(5,5);
        Assertions.assertEquals(10, result);
    }
}
