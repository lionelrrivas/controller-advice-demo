package com.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.demo")
public class ControllerAdviceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerAdviceDemoApplication.class, args);
	}

}
