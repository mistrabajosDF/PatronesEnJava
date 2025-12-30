package P2_E6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class ExcursionTest {

    @Test
    public void testInscripcionesExcursion() {
        Excursion excursion = new Excursion(
                "Dos días en kayak bajando el Paraná",
                LocalDate.of(2024, 11, 10),
                LocalDate.of(2024, 11, 11),
                "Puerto local", 15000, 1, 2);

        Usuario juan = new Usuario("Juan", "Gómez", "juan@mail.com");
        Usuario ana = new Usuario("Ana", "López", "ana@mail.com");
        Usuario pedro = new Usuario("Pedro", "Pérez", "pedro@mail.com");

        excursion.inscribir(juan);
        excursion.inscribir(ana);
        excursion.inscribir(pedro);

        String info = excursion.obtenerInformacion();
        //System.out.println(info); //debug

        // ejemplo de verificación
        assertEquals(true, info.contains("Dos días en kayak bajando el Paraná"));
        assertEquals(true, info.contains("Puerto local"));
    }
}

