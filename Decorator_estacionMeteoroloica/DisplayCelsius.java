package P2_E19;

public class DisplayCelsius extends WeatherDataDecorator {
    public DisplayCelsius(WeatherData wrappee) {
        super(wrappee);
    }

    @Override 
    public String displayData() {
        double tempC = (getTemperatura() - 32) / 1.8;
        return "Temperatura C: " + Math.round(tempC) + 
               "; Presión atmosf: " + getPresion() +
               "; Radiación solar: " + getRadiacionSolar() + ";";
    }
    
    //los gets los resuelve la clase padre
}
