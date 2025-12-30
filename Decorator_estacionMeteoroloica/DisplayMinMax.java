package P2_E19;

import java.util.List;

public class DisplayMinMax extends WeatherDataDecorator {
    public DisplayMinMax(WeatherData wrappee) {
        super(wrappee);
    }

    @Override
    public String displayData() {
    	//este se lo pide al anterior. si el anterior es la estacion, no dice 
    	//"Temperatura C", pero si esta displayCelsius como deco previo, lo va a decir
    	
        String base = wrappee.displayData();
        List<Double> temps = getTemperaturas();
        double min = temps.stream().mapToDouble(t -> t).min().orElse(0);
        double max = temps.stream().mapToDouble(t -> t).max().orElse(0);
        boolean enCelsius = base.contains("Temperatura C");
        if (enCelsius) {
            min = (min - 32) / 1.8;
            max = (max - 32) / 1.8;
        }
        return base + " Mínimo: " + Math.round(min) + " Máximo: " + Math.round(max) + ";";
    }
}