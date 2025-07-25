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
	// @Autowired
	// private ThemeRepository themeRepository;

	// http://localhost:8080/
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * Temos que ver sobre esses endpoints e em que momento cada coisa será salva/requisitada
	 * porque, por exemplo, obter TODOS os conteudos de todos os temas, independente de qual 
	 * tema a pessoa clicar, pode (e é) ser ruim. Mas naõ só isso, dependendo de como for o endpoint,
	 * toda vez que for na página "/atividades", por exemplo, faria o requisito de TODOS os temas?
	 * é meio besteira, mas me parece confuso e por isso deixei
	 */

	/**
	 * tb n tenho certeza quanto a esse post, mas desenvolvi melhor acima e abaixo
	 */
	@PostMapping("/post")
	public void salvaTemas(@RequestBody Tema tema) {
		/** to do */
	}

	/** a principio, penso em trocar o /get por /atividades e haver, para cada atividade, um 
	 * end point para requisitar apenas o tema 
	 * 
	 * mas isso pode ser ruim tambem em tempo de resposta nao seiiii temos que decidir juntas!
	 */
	@GetMapping("/get")
	public Iterable<Tema> obtemTema() {
		/** to do */
		return null;
	}
}
