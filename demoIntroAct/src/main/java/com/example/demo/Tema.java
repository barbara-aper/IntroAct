package com.example.demo;

import java.util.List;

public class Tema {
    private String nome;
    private String descricao;
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
