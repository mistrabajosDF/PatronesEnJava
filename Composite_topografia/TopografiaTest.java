package P2_E11;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TopografiaTest {
    Topografia agua;
    Topografia tierra;
    Topografia mixtaEjemplo;

    @BeforeEach
    public void setUp() {
        agua = new TopografiaAgua();
        tierra = new TopografiaTierra();

        // Topografía compuesta: (1 + 0 + 0 + 1) / 4 = 0.5
        mixtaEjemplo = new TopografiaMixta(Arrays.asList(
            agua, tierra, tierra, agua
        ));
    }

    @Test
    public void testProporcionAguaSimple() {
        assertEquals(1.0, agua.proporcionAgua());
        assertEquals(0.0, tierra.proporcionAgua());
    }

    @Test
    public void testProporcionMixta() {
        assertEquals(0.5, mixtaEjemplo.proporcionAgua());
    }

    @Test
    public void testIgualdadTopografias() {
    	//se prueba que dos topografías idénticas en contenido 
    	//sean consideradas iguales. Por eso hace new
        Topografia otra = new TopografiaMixta(Arrays.asList(
            new TopografiaAgua(),
            new TopografiaTierra(),
            new TopografiaTierra(),
            new TopografiaAgua()
        ));
        assertEquals(mixtaEjemplo, otra); //invoca el método equals(Object obj) de la clase Topografia
    }

    @Test
    public void testDesigualdadPorOrden() {
    	//se prueba que cambiar el orden de los componentes rompe la igualdad, 
    	//List.equals() compara elementos en orden y por contenido.
        Topografia otra = new TopografiaMixta(Arrays.asList(
            tierra, agua, agua, tierra
        ));
        assertNotEquals(mixtaEjemplo, otra);
    }
    
    @Test
    public void testPantanoProporcion() {
        Topografia pantano = new TopografiaPantano();
        assertEquals(0.7, pantano.proporcionAgua());
    }

}
