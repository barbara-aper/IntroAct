package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {

    @GetMapping("/")
    public String index() {
        return "index"; // carrega templates/index.html
    }

    @GetMapping("/atividades")
    public String atividades() {
        return "atividades"; // carrega templates/atividades.html
    }

    @GetMapping("/contatos")
    public String contatos() {
        return "contatos"; // carrega templates/contatos.html
    }
}
