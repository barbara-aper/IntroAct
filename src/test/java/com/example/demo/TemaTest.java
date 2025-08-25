package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TemaTest {
    private Tema tema;

    @BeforeEach
    public void init() {
        this.tema = new Tema();
        this.tema.setNome("Aritmética e Tipos de Dados");
        this.tema.setLink("https://colab.research.google.com/drive/14z8nnNX9MXQ4WUoSX1pO5LtRqOo7E-XE");
        this.tema.setDescricao("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae metus sed leo finibus elementum at quis augue.");
    }

    @Test
    public void nomeCorreto() {
        String expected = "Aritmética e Tipos de Dados";
        assertEquals(expected, this.tema.getNome());
    }

    @Test
    public void descricaoCorreta() {
        String expected = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae metus sed leo finibus elementum at quis augue.";
        assertEquals(expected, this.tema.getDescricao());
    }

    @Test
    public void linkCorreto() {
        String expected = "https://colab.research.google.com/drive/14z8nnNX9MXQ4WUoSX1pO5LtRqOo7E-XE";
        assertEquals(expected, this.tema.getLink());
    }

    @Test
    public void atividadesCorretas() {
        assertTrue(this.tema.getAtividades().isEmpty(), "A lista de atividades deveria estar vazia!");
    }

}
