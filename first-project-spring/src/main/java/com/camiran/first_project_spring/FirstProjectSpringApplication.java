package com.camiran.first_project_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.camiran.first_project_spring.domain")
public class FirstProjectSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectSpringApplication.class, args);
	}

}
