package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * Atividade é uma entidade que representa o conjunto de exercícios disponíveis em determinado Tema
 */
@Entity
public class Atividade {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;

    @OneToMany(cascade=CascadeType.PERSIST) 
    private List<Exercicio> exercicios = new ArrayList<>();
    private String tema;

    /**
     * Define a lista de exercicios como a passada por parametros.
     * @param exercicios lista de exercicios.
     */
    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }

    /**
     * Adiciona um exercicio à lista de exercícios.
     * @param exercicio exercicio à ser adicionado a atividade.
     */
    public void addExercicio(Exercicio exercicio) {
        this.exercicios.add(exercicio);
    }

    /**
     * Define nome do tema da atividade.
     * @param tema tema da atividade.
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * Obtem o id de um objeto especifico atividade.
     * @return o id do objeto.
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Obtem todos os exercícios existentes na atividade.
     * @return lista de exercícios.
     */
    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    /**
     * Obtem o tema da sessão de atividades.
     * @return o tema da sessão de atividade.
     */
    public String getTema() {
        return tema;
    }
}
