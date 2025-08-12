package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Service @RestController
public class ThemeService {
    @Autowired
    private final ThemeRepository themeRepository;
    
    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    @PostMapping("/post")
	public void salvaTemas(@RequestBody List<Tema> temas) {
		for (Tema l : temas)
			themeRepository.save(l);
	}

	@GetMapping("/get")
	public List<Tema> obtemTemas() {
		return (List<Tema>) themeRepository.findAll();
	}

	@DeleteMapping("/delete")
	public void deletaTemas() {
		themeRepository.deleteAll();
	}
}
