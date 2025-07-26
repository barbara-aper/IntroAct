package com.example.demo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Atividade {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade=CascadeType.PERSIST)
    private List<Exercicio> exercicios;
    private String tema;

    /**
     * Obtem o id de um objeto especifico atividade
     * @return o id do objeto
     */
    public Long getId() {
        return id;
    }
    
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
