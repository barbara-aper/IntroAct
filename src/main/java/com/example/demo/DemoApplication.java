package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classse principal que inicializa a chamada da aplicação Spring do SpringBoot
 */
@SpringBootApplication
public class DemoApplication {
	// http://localhost:8080/
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
