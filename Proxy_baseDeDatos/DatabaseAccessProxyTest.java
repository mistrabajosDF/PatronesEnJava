package P2_E17;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class DatabaseAccessProxyTest {

    @Test
    public void testAccesoDenegadoSiNoAutenticado() {
        DatabaseAccess proxy = new DatabaseAccessProxy(new DatabaseRealAccess());
        assertThrows(SecurityException.class, () -> {
            proxy.getSearchResults("select * from comics where id=1");
        });
    }

    @Test
    public void testAccesoPermitidoSiAutenticado() {
        DatabaseAccessProxy proxy = new DatabaseAccessProxy(new DatabaseRealAccess());
        proxy.authenticate("admin", "1234");
        Collection<String> resultados = proxy.getSearchResults("select * from comics where id=1");
        assertFalse(resultados.isEmpty());
    }

    @Test
    public void testInsertarYBuscarConAutenticacion() {
        DatabaseAccessProxy proxy = new DatabaseAccessProxy(new DatabaseRealAccess());
        proxy.authenticate("admin", "1234");

        int id = proxy.insertNewRow(Arrays.asList("Patoruzú", "La flor"));
        Collection<String> resultados = proxy.getSearchResults("select * from comics where id=" + id);

        assertTrue(resultados.contains("Patoruzú"));
    }
}
