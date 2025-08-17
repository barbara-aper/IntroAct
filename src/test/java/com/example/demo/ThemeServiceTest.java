package com.example.demo;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ThemeServiceTest {
    @Mock private ThemeRepository themeRepository;
    @InjectMocks private ThemeService themeService;

    /**
     * Teste para o método obtemTemas.
     * Verifica se o serviço retorna corretamente a lista que o repositório fornece.
     */
    @Test
    void testObtemTemas() {
        Tema tema1 = new Tema();    tema1.setNome("Algebra booleana");
        Tema tema2 = new Tema();    tema2.setNome("Listas");

        List<Tema> temas = Arrays.asList(tema1, tema2);

        when(themeRepository.findAll()).thenReturn(temas);
        List<Tema> expected = themeService.obtemTemas();

        assertNotNull(expected);
        assertEquals(2, expected.size());
        assertEquals("Algebra booleana", expected.get(0).getNome());

        verify(themeRepository, times(1)).findAll();
    }

    /**
     * Teste para o método salvaTemas.
     * Verifica se o serviço chama o método save() do repositório para cada item da lista.
     */
    @Test
    void testSalvaTemas() {
        Tema tema1 = new Tema();    tema1.setNome("Algebra booleana");
        Tema tema2 = new Tema();    tema2.setNome("Listas");

        List<Tema> temas = Arrays.asList(tema1, tema2);
        themeService.salvaTemas(temas);

        verify(themeRepository, times(2)).save(org.mockito.ArgumentMatchers.any(Tema.class));
        verify(themeRepository, times(1)).save(tema1);
        verify(themeRepository, times(1)).save(tema2);
    }

    /**
     * Teste para o método deletaTemas.
     * Verifica se o serviço chama corretamente o método deleteAll() do repositório.
     */
    @Test
    void testDeletaTemas() {
        themeService.deletaTemas();
        verify(themeRepository, times(1)).deleteAll();
    }
}