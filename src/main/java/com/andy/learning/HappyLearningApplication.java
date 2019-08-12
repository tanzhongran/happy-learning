package com.andy.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

@SpringBootApplication
public class HappyLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyLearningApplication.class, args);
	}

}
