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
 * Entidade com o tema geral para um conjunto de atividades, com nome e uma 
 */
@Entity
public class Tema {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) private Long id;
    
    private String nome;
    private String descricao;
    @OneToMany(cascade=CascadeType.PERSIST) 
    private List<Atividade> atividades = new ArrayList<>();

    /**
     * Define nome para o tema.
     * @param nome nome do tema.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Define descricao para o tema.
     * @param descricao descricao do tema.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Define as atividades de um tema.
     * @param atividades lista de atividades.
     */
    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    /**
     * Adiciona uma atividade ao tema.
     * @param atividade atividade a ser adicionada a lista de atividades do tema.
     */
    public void addAtividade(Atividade atividade) {
        this.atividades.add(atividade);
    }

    /**
     * Obtem o id de um objeto especifico tema
     * @return o id do objeto
     */
    public Long getId() {
        return this.id;
    }
    
    /**
     * Obtem o nome do tema
     * @return nome do tema
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Obtem a descrição do tema
     * @return descrição do tema
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Obtem as atividades do tema
     * @return lista de atividades do tema
     */
    public List<Atividade> getAtividades() {
        return this.atividades;
    }
}
