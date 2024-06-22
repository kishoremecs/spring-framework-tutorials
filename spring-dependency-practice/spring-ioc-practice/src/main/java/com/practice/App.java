package com.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("com.practice");
        ctx.registerShutdownHook();

        LocalDate date = ctx.getBean(LocalDate.class);
        System.out.println(date);

    }

    public int add(int a, int b) {
        return a + b;
    }
}
