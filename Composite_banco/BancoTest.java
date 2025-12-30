package P2_E14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BancoTest {

    private Banco banco;
    private Automovil auto;
    private Alquiler alquiler;
    private PrendaCombinada combinada;

    @BeforeEach
    public void setUp() {
        banco = new Banco();

        auto = new Automovil("Toyota Corolla", 3, 8000000);
        alquiler = new Alquiler(LocalDate.of(2025, 7, 1), LocalDate.of(2026, 7, 1), 200000);

        combinada = new PrendaCombinada();
        combinada.agregar(auto);
        combinada.agregar(alquiler);

        banco.registrarPrenda(combinada);
    }

    @Test
    public void testValorPrendarioAutomovil() {
        assertEquals(3920000, auto.valorPrendario(), 0.01);
    }

    @Test
    public void testValorPrendarioAlquiler() {
        double costoMensual = 200000;
        double liquidez = 0.9;

        long mesesRestantes = Math.max(0, ChronoUnit.MONTHS.between(LocalDate.now(), LocalDate.of(2026, 7, 1)));

        double valorEsperado = mesesRestantes * costoMensual * liquidez;

        assertEquals(valorEsperado, alquiler.valorPrendario(), 0.01);
    }

    @Test
    public void testValorTotalPrendario() {
        double valorAuto = 5600000;

        double costoMensual = 200000;

        long mesesRestantes = Math.max(0, ChronoUnit.MONTHS.between(LocalDate.now(), LocalDate.of(2026, 7, 1)));

        double valorAlquiler = mesesRestantes * costoMensual;

        double liquidezCombinada = 0.5;
        double valorEsperado =
            (valorAuto + valorAlquiler) * liquidezCombinada;

        assertEquals(valorEsperado, banco.valorTotalPrendario(), 0.01);
    }
}
