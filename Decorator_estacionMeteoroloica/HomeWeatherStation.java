package P2_E19;

import java.util.List;

public class HomeWeatherStation implements WeatherData {
    private List<Double> temperaturas;

    public HomeWeatherStation(List<Double> temperaturas) {
        this.temperaturas = temperaturas;
    }

    public double getTemperatura() {
        return temperaturas.get(temperaturas.size() - 1); // última temp
    }

    public double getPresion() {
        return 1008;
    }

    public double getRadiacionSolar() {
        return 200;
    }

    public List<Double> getTemperaturas() {
        return this.temperaturas;
    }

    public String displayData() {
        return "Temperatura F: " + this.getTemperatura() + 
               "; Presión atmosf: " + this.getPresion() + 
               "; Radiación solar: " + this.getRadiacionSolar() + ";";
    }
}
