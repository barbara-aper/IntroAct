package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AtividadeTest {
    private Atividade atv;

    @BeforeEach
    public void init() {
        this.atv = new Atividade();
        this.atv.setTema("Aritmética e Tipos de Dados");
    }

    @Test
    public void temaCorreto() {
        String expected = "Aritmética e Tipos de Dados";
        assertEquals(expected, atv.getTema());
    }

    @Test
    public void exerciciosCorreto() {
        assertTrue(this.atv.getExercicios().isEmpty(), "A lista de exercicios deveria estar vazia!");
    }
}
