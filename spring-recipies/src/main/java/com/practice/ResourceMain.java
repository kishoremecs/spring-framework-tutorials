package com.practice;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
public class ResourceMain {
  public static void main(String[] args) throws Exception {
    var resource = new ClassPathResource("discounts.properties");
    var props = PropertiesLoaderUtils.loadProperties(resource);
    System.out.println("And don't forget our discounts!");
    System.out.println(props);
  }
}