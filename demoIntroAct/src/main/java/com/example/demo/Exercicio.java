package com.example.demo;

import java.util.List;

public class Exercicio {
    private String id;
    private String enunciado;
    private Dificuldade dificuldade;
    private Tipo tipo;
    private List<String> alternativas;
    private List<String> gabarito;
    
    /**
     * Obtem o id do exercício
     * @return o id do exercício
     */
    public String getId() {
        return id;
    }

    /**
     * Obtem o enunciado do exercício
     * @return o enunciado do exercício
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * Obtem a dificuldade do exercício
     * @return da dificuldade do exercício
     */
    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    /**
     * Obtem o tipo do exercício
     * @return o tipo do exercício
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Obtem as alternativas possíveis para escolha como resposta
     * @return uma lista com as alternativas
     */
    public List<String> getAlternativas() {
        return alternativas;
    }

    /**
     * Obtem o gabarito com as respostas dos exercícios
     * @return uma lista com as respostas corretas dos exercícios
     */
    public List<String> getGabarito() {
        return gabarito;
    }
}
