package com.example.demo;

import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
    @GetMapping("/index")
    public String index() {
        return "index"; // carrega templates/index.html
    }

    @GetMapping("/atividades")
    public String atividades(Model model) {
        Iterator<Tema> temas = this.obtemTema().iterator();
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
