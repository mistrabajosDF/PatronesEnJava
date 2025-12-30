package P2_E5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DecodificadorTest {

    private Pelicula thor, capitanAmerica, ironMan, dunkirk, rocky, rambo;
    private Decodificador deco;

    @BeforeEach
    public void setUp() {
        thor = new Pelicula("Thor", 7.9, 2007);
        capitanAmerica = new Pelicula("Capitan America", 7.8, 2016);
        ironMan = new Pelicula("Iron Man", 7.9, 2010);
        dunkirk = new Pelicula("Dunkirk", 7.9, 2017);
        rocky = new Pelicula("Rocky", 8.1, 1976);
        rambo = new Pelicula("Rambo", 7.8, 1979);

        thor.agregarSimilar(capitanAmerica);
        thor.agregarSimilar(ironMan);
        rocky.agregarSimilar(rambo);
        
        CriterioSugerencia criterio = new PorNovedad();
        
        List<Pelicula> grilla = Arrays.asList(thor, capitanAmerica, ironMan, dunkirk, rocky, rambo);
        deco = new Decodificador(grilla, criterio);

        deco.reproducir(thor);
        deco.reproducir(rocky);
    }

    @Test
    public void testSugerenciasPorSimilaridad() {
        deco.setCriterio(new PorSimilaridad());
        List<Pelicula> sugerencias = deco.sugerencias();

        assertTrue(sugerencias.contains(capitanAmerica));
        assertTrue(sugerencias.contains(ironMan));
        System.out.println("Sugerencias por similaridad: " + sugerencias);
    }

    @Test
    public void testSugerenciasPorPuntaje() {
        deco.setCriterio(new PorPuntaje());
        List<Pelicula> sugerencias = deco.sugerencias();

        assertTrue(sugerencias.contains(dunkirk)); // asume que no fue reproducida
        System.out.println("Sugerencias por puntaje: " + sugerencias);
    }

    @Test
    public void testSugerenciasPorNovedad() {
        deco.setCriterio(new PorNovedad());
        List<Pelicula> sugerencias = deco.sugerencias();

        assertTrue(sugerencias.contains(dunkirk));
        System.out.println("Sugerencias por novedad: " + sugerencias);
    }
}
