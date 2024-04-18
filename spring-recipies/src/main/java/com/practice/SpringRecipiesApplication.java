package com.practice;

import com.practice.config.SequenceConfiguration;
import com.practice.sequence.Sequence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringRecipiesApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringRecipiesApplication.class, args);
		var context = new AnnotationConfigApplicationContext(SequenceConfiguration.class);
		System.out.println(context);
		var generator = (Sequence) context.getBean("sequence");
		// var generator = context.getBean("sequence", Sequence.class);
		// var generator = context.getBean(Sequence.class);
		System.out.println(generator.nextValue());
	}

}
