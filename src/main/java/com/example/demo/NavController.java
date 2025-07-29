package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
    private final ThemeService themeService;

    public NavController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping("/index")   
    public String index() {
        return "index"; // carrega templates/index.html
    }

    @GetMapping("/atividades")
    public String atividades(Model model) {
        List<Tema> temas = (List<Tema>) this.themeService.obtemTemas();
        model.addAttribute("temas", temas);
        return "atividades"; // carrega templates/atividades.html
    }

    @GetMapping("/contatos")
    public String contatos() {
        return "contatos"; // carrega templates/contatos.html
    }

    @GetMapping("/error")
    public String error() {
        return "error";  // carrega templates/error.html
    }
}
