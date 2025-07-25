package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
	// http://localhost:8080/
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostMapping("/post")
	public void obtemTemas(@RequestBody Tema tema) {
		/** to do */
	}

	@GetMapping("/get")
	public Iterable<Tema> obtemTema() {
		/** to do */
		return null;
	}
}
