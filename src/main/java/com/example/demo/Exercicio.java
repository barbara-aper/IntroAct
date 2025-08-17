package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/** 
 * Exercício é uma entidade  com problema a ser resolvido pelo usuário. Ele é composto por um enunciado, 
 * um conjunto de alternativas para resposta e modelado com dependencia do tipo do exercício.
 */
@Entity
public class Exercicio {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String idExercicio;
    private String enunciado;
    private Dificuldade dificuldade;
    private Tipo tipo;
    @ElementCollection private List<String> alternativas = new ArrayList<>();
    @ElementCollection private List<String> gabarito = new ArrayList<>();

    /**
     * Define id do exercício.
     * @param idExercicio id do exercício.
     */
    public void setIdExercicio(String idExercicio) {
        this.idExercicio = idExercicio;
    }

    /**
     * Define enunciado de um exercício.
     * @param enunciado enunciado do exercício.
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    /**
     * Define a dificuldade do exercício.
     * @param dificuldade dificuldade do exercício.
     */
    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }

    /**
     * Define o tipo do exercício (MULTIPLA_ESCOLHA, CORRELACAO, ESCRITA,PREENCHIMENTO_DE_LACUNAS).
     * @param tipo tipo do exercício.
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * Define as possiveis alternativas de resposta do usuário ao exercício.
     * @param alternativas lista de alternativas.
     */
    public void setAlternativas(List<String> alternativas) {
        this.alternativas = alternativas;
    }

    /**
     * Define gabarito do exercício.
     * @param gabarito gabarito do exercício.
     */
    public void setGabarito(List<String> gabarito) {
        this.gabarito = gabarito;
    }

    /**
     * Obtem o id de um objeto especifico exercicio.
     * @return o id do objeto.
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Obtem o id do exercício.
     * @return o id do exercício .
     */
    public String getIdExercicio() {
        return idExercicio;
    }

    /**
     * Obtem o enunciado do exercício.
     * @return o enunciado do exercício.
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * Obtem a dificuldade do exercício.
     * @return da dificuldade do exercício.
     */
    public Dificuldade getDificuldade() {
        return dificuldade;
    }

    /**
     * Obtem o tipo do exercício.
     * @return o tipo do exercício.
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * Obtem as alternativas possíveis para escolha como resposta.
     * @return uma lista com as alternativas.
     */
    public List<String> getAlternativas() {
        return alternativas;
    }

    /**
     * Obtem o gabarito com as respostas dos exercícios.
     * @return uma lista com as respostas corretas dos exercícios.
     */
    public List<String> getGabarito() {
        return gabarito;
    }
}
