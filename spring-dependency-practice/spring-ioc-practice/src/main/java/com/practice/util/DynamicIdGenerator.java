package com.practice.util;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import jakarta.annotation.*;
import org.springframework.context.Lifecycle;

import java.util.UUID;

public class DynamicIdGenerator implements InitializingBean, DisposableBean, Lifecycle {

    public void customInit() {
        System.out.println("@Bean callbacks: init method is called");
    }

    public void customDestroy() {
        System.out.println("@Bean callbacks: destroy method is called");
    }

    @PostConstruct
    public void annotatedInit() {
        System.out.println("@PostConstruct: method is called");
    }

    @PreDestroy
    public void annotatedDestroy() {
        System.out.println("@PreDestroy: destroy callback method is called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean: destroy method is called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean: afterPropertiesSet method is called");
    }

    public String generateUniqueId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void start() {
        System.out.println("Lifecycle start: start method is called");
    }

    @Override
    public void stop() {
        System.out.println("Lifecycle stop: stop method is called");
    }

    @Override
    public boolean isRunning() {
        return true;
    }
}
