package com.andy.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

@SpringBootApplication
@EnableJpaAuditing
public class HappyLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyLearningApplication.class, args);
	}

}
