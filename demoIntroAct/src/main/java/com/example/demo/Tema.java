package com.example.demo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tema {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    private String descricao;
    @OneToMany
    private List<Atividade> atividades;
    
    /**
     * Obtem o nome do tema
     * @return nome do tema
     */
    public String getNome() {
        return nome;
    }

    /**
     * Obtem a descrição do tema
     * @return descrição do tema
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Obtem as atividades do tema
     * @return lista de atividades do tema
     */
    public List<Atividade> getAtividades() {
        return atividades;
    }
}
