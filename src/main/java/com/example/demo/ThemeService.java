package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/** 
 * Fornece os serviços possíveis no banco de dados
 */
@Service @RestController
public class ThemeService {
    @Autowired private final ThemeRepository themeRepository;
    
    /**
	 * Contrutor dos servicos para comunicacao com o banco de dados
     * @param themeRepository repositorio de tema
     */
    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    /**
	 * Comunicação para enviar uma lista de tema ao banco de dados
     * @param temas lista de tema
     */
    @PostMapping("/post")
	public void salvaTemas(@RequestBody List<Tema> temas) {
		for (Tema l : temas)
			themeRepository.save(l);
	}

	/**
	 * Comunicação para obter uma lista de tema do banco de dado
	 * @return lista de tema
	 */
	@GetMapping("/get")
	public List<Tema> obtemTemas() {
		return (List<Tema>) themeRepository.findAll();
	}

	/**
	 * Comunicaçao para deletar todos os dados do banco de dados
	 */
	@DeleteMapping("/delete")
	public void deletaTemas() {
		themeRepository.deleteAll();
	}
}
