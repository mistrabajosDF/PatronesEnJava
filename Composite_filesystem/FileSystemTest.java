package P2_E12;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class FileSystemTest {

    private FileSystem fs; //tiene que declararse aca para que los test la vean

    @BeforeEach
    public void setUp() {
        Directorio raiz = new Directorio("raiz", LocalDate.of(2023, 1, 1));
        Archivo a1 = new Archivo("archivo1.txt", LocalDate.of(2023, 1, 10), 100);
        Archivo a2 = new Archivo("archivo2.txt", LocalDate.of(2023, 3, 10), 200);
        Archivo a3 = new Archivo("archivo1.txt", LocalDate.of(2023, 2, 10), 300);

        Directorio sub1 = new Directorio("sub1", LocalDate.of(2023, 1, 15));
        Directorio sub2 = new Directorio("sub2", LocalDate.of(2023, 1, 20));
        sub1.agregarElemento(a1);
        sub2.agregarElemento(a2);
        sub2.agregarElemento(a3);

        raiz.agregarElemento(sub1);
        raiz.agregarElemento(sub2);

        fs = new FileSystem(raiz);
    }

    @Test
    public void testTamanoTotalOcupado() {
        assertEquals(696, fs.tamanoTotalOcupado());
    }

    @Test
    public void testArchivoMasGrande() {
        assertEquals("archivo1.txt", fs.archivoMasGrande().getNombre());
        assertEquals(300, fs.archivoMasGrande().tamano());
    }

    @Test
    public void testArchivoMasNuevo() {
        assertEquals("archivo2.txt", fs.archivoMasNuevo().getNombre());
    }

    @Test
    public void testBuscarUnico() {
        assertEquals("archivo1.txt", fs.buscar("archivo1.txt").getNombre());
    }

    @Test
    public void testBuscarTodos() {
        assertEquals(2, fs.buscarTodos("archivo1.txt").size());
    }
}
