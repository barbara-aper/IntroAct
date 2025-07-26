package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private ThemeRepository themeRepository;

	@PostMapping("/post")
	public void salvaTemas(@RequestBody Tema tema) {
		themeRepository.save(tema);
	}

	@GetMapping("/get")
	public Iterable<Tema> obtemTema() {
		return themeRepository.findAll();
	}
}
