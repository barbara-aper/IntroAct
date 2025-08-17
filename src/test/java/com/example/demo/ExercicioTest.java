package com.example.demo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExercicioTest {
    private Exercicio ex;

    @BeforeEach
    public void init() {
        this.ex = new Exercicio();
        this.ex.setIdExercicio("T101");
        this.ex.setEnunciado("Qual função é utilizada para exibir algo na tela com Python?");
        this.ex.setDificuldade(Dificuldade.FACIL);
        this.ex.setTipo(Tipo.MULTIPLA_ESCOLHA);
        this.ex.setAlternativas(List.of("print()", "show()", "display()", "echo()"));
        this.ex.setGabarito(List.of("print()"));
    }

    @Test
    public void idExercicioCorreto() {
        String expected = "T101";
        assertEquals(expected, this.ex.getIdExercicio());
    }

    @Test
    void enunciadoCorreto() {
        String expected = "Qual função é utilizada para exibir algo na tela com Python?";
        assertEquals(expected, this.ex.getEnunciado());
    }

    @Test
    void dificuldadeCorreta() {
        Dificuldade expected = Dificuldade.FACIL;
        assertEquals(expected, this.ex.getDificuldade());
    }

    @Test
    void tipoCorreto() {
        Tipo expected = Tipo.MULTIPLA_ESCOLHA;
        assertEquals(expected, this.ex.getTipo());
    }
}
