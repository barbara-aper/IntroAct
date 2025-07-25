package com.example.demo;

import java.util.List;

public class Atividade {
    private List<Exercicio> exercicios;
    private String tema;
    
    /**
     * Obtem todos os exercícios existentes na atividade
     * @return lista de exercícios
     */
    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    /**
     * Obtem o tema da sessão de atividades
     * @return o tema da sessão de atividade
     */
    public String getTema() {
        return tema;
    }
}
