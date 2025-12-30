package P2_E19;

import java.util.List;

public abstract class WeatherDataDecorator implements WeatherData {
    protected WeatherData wrappee;

    public WeatherDataDecorator(WeatherData wrappee) {
        this.wrappee = wrappee;
    }

    public double getTemperatura() {
        return wrappee.getTemperatura();
    }

    public double getPresion() {
        return wrappee.getPresion();
    }

    public double getRadiacionSolar() {
        return wrappee.getRadiacionSolar();
    }

    public List<Double> getTemperaturas() {
        return wrappee.getTemperaturas();
    }
}
