package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controla a troca de páginas pela navbar do aplicativo utilizando o protocolo http
 * com as urls específicas para cada página.
 */
@Controller
public class NavController {
    private final ThemeService themeService;

    /**
     * Construtor do controlador de acessos com html da navbar.
     * @param themeService servico de temas.
     */
    public NavController(ThemeService themeService) {
        this.themeService = themeService;
    }

    /**
     * Mapeia a requisição para a página inicial.
     * @return endpoint /index a acessar.
     */
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * Mapeia a requisição para a página de atividades.
     * @param model modelo com os dados do banco de dados.
     * @return endpoint /atividades a acessar.
     */
    @GetMapping("/atividades")
    public String atividades(Model model) {
        List<Tema> temas = (List<Tema>) this.themeService.obtemTemas();
        model.addAttribute("temas", temas);
        return "atividades";
    }

    /**
     * Mapeia a requisição para a página de um exercício.
     * @param model modelo com os dados do banco de dados.
     * @param idTema id do tema desejado a acessar.
     * @param idAtividade id da atividade desejada a acessar.
     * @return endpoint /exercicio/idTema/idAtividade a acessar.
     */
    @GetMapping("/exercicio/{idTema}/{idAtividade}")
    public String exercicio(Model model, @PathVariable int idTema, @PathVariable int idAtividade) {
        List<Tema> temas = (List<Tema>) this.themeService.obtemTemas();
        Tema tema = temas.get(idTema);
        Atividade atv = tema.getAtividades().get(idAtividade);
        model.addAttribute("atividade", atv);
        return "exercicio";
    }

    /**
     * Mapeia a requisição para a página de contato.
     * @return endpoint /contato a acessar
     */
    @GetMapping("/contato")
    public String contato() {
        return "contato";
    }

    /**
     * Mapeia a requisição para a página de error.
     * @return endpoint /error a acessar
     */
    @GetMapping("/error")
    public String error() {
        return "error";
    }

    /**
     * Mapeia a requisição para a página de faq.
     * @return endpoint /faq a acessar
     */
    @GetMapping("/faq")
    public String faq() {
        return "faq";
    }
}
