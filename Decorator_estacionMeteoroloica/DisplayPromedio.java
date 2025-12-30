package P2_E19;

public class DisplayPromedio extends WeatherDataDecorator {
    public DisplayPromedio(WeatherData wrappee) {
        super(wrappee);
    }

    @Override
    public String displayData() {
        String base = wrappee.displayData();
        double promedio = getTemperaturas().stream().mapToDouble(t -> t).average().orElse(0);
        boolean enCelsius = base.contains("Temperatura C");
        if (enCelsius) {
            promedio = (promedio - 32) / 1.8;
        }
        return base + " Promedio: " + Math.round(promedio) + ";";
    }
}