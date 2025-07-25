package com.example.demo;

import java.util.List;

public class Atividade {
    private List<Exercicio> exercicios;
    private Tema tema;
    
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
    public Tema getTema() {
        return tema;
    }
}
