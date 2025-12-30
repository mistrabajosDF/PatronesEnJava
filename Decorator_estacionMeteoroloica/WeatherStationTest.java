package P2_E19;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherStationTest {

    @Test
    void testDisplayDataDecorators() {
        List<Double> temps = List.of(80.6, 86.0, 89.6); // (27, 30, 32 C)
        WeatherData estacion = new HomeWeatherStation(temps);

        estacion = new DisplayCelsius(estacion);
        estacion = new DisplayPromedio(estacion);
        estacion = new DisplayMinMax(estacion);

        String esperado = "Temperatura C: 32; Presión atmosf: 1008.0; Radiación solar: 200.0; Promedio: 30; Mínimo: 27 Máximo: 32;";
        assertEquals(esperado, estacion.displayData());
    }
}

//Temperatura C: 32; Presión atmosf: 1008.0; Radiación solar: 200.0; Promedio: 30; Mínimo: 27 Máximo: 32;

