package P2_E19;

/*
 * 
Sea una estación meteorológica implementada con la clase HomeWeatherStation con sensores para conocer fenómenos físicos. La misma implementa los
siguientes métodos:

//retorna la temperatura en grados Fahrenheit.
public double getTemperatura()
//retorna la presión atmosférica en hPa
public double getPresion()
//retorna la radiación solar
public double getRadiacionSolar()
//retorna una lista con todas las temperaturas sensadas hasta el
momento, en grados Fahrenheit
public List<Double> getTemperaturas()
//retorna un reporte de todos los datos: temperatura, presión, y
radiación solar.
public String displayData(){
return "Temperatura F: " + this.getTemperatura() +"Presión atmosf: " + this.getPresion() + "Radiación solar: " + this.getRadiacionSolar();
} 

El código de la clase HomeWeatherStation no se puede modificar, y se requiere integrar diferentes configuraciones que combinen algunas de las siguientes funcionalidades:
● La temperatura en grados Celsius (ºC = (ºF-32) ÷ 1.8).
● El promedio de las temperaturas históricas.
● Las temperaturas mínima y máxima histórica.
Esto implica que la aplicación debe ser capaz de adaptarse a diferentes necesidades de visualización. Por ejemplo:
“Temperatura F: 86; Presión atmosf: 1008; Radiación solar: 200; Promedio: 86;”

La aplicación puede mostrar diferentes configuraciones de los datos, según lo que el usuario haya seleccionado. 
Debe proveer la implementación del mensaje public String displayData() que devuelva los datos según lo configurado (dado que la app aun no cuenta con interface de usuario).

 */

import java.util.List;

public interface WeatherData {
    public abstract double getTemperatura();
    public abstract double getPresion();
    public abstract double getRadiacionSolar();
    public abstract List<Double> getTemperaturas();
    public abstract String displayData();
}