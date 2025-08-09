package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NavController {
    private final ThemeService themeService;

    public NavController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/atividades")
    public String atividades(Model model) {
        List<Tema> temas = (List<Tema>) this.themeService.obtemTemas();
        model.addAttribute("temas", temas);
        return "atividades";
    }

    @GetMapping("/exercicio/{idTema}/{idAtividade}")
    public String exercicio(Model model, @PathVariable int idTema, @PathVariable int idAtividade) {
        List<Tema> temas = (List<Tema>) this.themeService.obtemTemas();
        Tema tema = temas.get(idTema);
        Atividade atv = tema.getAtividades().get(idAtividade);
        model.addAttribute("atividade", atv);
        return "exercicio";
    }

    @GetMapping("/contato")
    public String contato() {
        return "contato";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/faq")
    public String faq() {
        return "faq";
    }
}
