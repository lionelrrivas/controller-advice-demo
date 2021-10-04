package com.fedex.controlleradvicedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.fedex")
public class ControllerAdviceDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControllerAdviceDemoApplication.class, args);
	}

}
