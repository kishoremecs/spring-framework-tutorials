package com.practice;

import com.practice.config.*;
import com.practice.sequence.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class AppSample {
  public static void main(String[] args) {
//    var cfg = SequenceConfiguration.class;
    var cfg = new Class[] { PrefixConfiguration.class, SequenceConfiguration.class };
    var context = new AnnotationConfigApplicationContext(cfg);
    try (var ctx = new AnnotationConfigApplicationContext(cfg)) {
      var generator = ctx.getBean(Sequence.class);
      System.out.println(generator.nextValue());
      System.out.println(generator.nextValue());
    }
  }
}