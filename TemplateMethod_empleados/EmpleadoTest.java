package P2_E2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    @Test
    public void sueldoTemporarioCasadoConHijos() {
        Empleado t = new Temporario(40, true, 2);
        // Basico = 20000 + 40*300 = 32000
        // Adicional = 5000 + 2*2000 = 9000
        // Descuento = 32000*0.13 + 9000*0.05 = 4160 + 450 = 4610
        // Sueldo = 32000 + 9000 - 4610 = 36390
        assertEquals(36390, t.sueldo(), 0.01);
    }

    @Test
    public void sueldoPasanteCon3Examenes() {
        Empleado p = new Pasante(3);
        // Basico = 20000
        // Adicional = 6000
        // Descuento = 20000*0.13 + 6000*0.05 = 2600 + 300 = 2900
        // Sueldo = 20000 + 6000 - 2900 = 23100
        assertEquals(23100, p.sueldo(), 0.01);
    }

    @Test
    public void sueldoPlantaCasadoConHijosYAntiguedad() {
        Empleado e = new Planta(true, 2, 3);
        // Basico = 50000
        // Adicional = 5000 + 4000 + 6000 = 15000
        // Descuento = 50000*0.13 + 15000*0.05 = 6500 + 750 = 7250
        // Sueldo = 50000 + 15000 - 7250 = 57750
        assertEquals(57750, e.sueldo(), 0.01);
    }
}
