package P2_E6;

public abstract class EstadoExcursion {

	protected String obtenerInformacion(Excursion excursion) {
	    String info = "Nombre: " + excursion.getNombre()
	        + " | Precio: $" + String.format("%.2f", excursion.getCosto())
	        + " | Inicio: " + excursion.getFechaInicio()
	        + " - Fin: " + excursion.getFechaFin()
	        + " | Punto de encuentro: " + excursion.getPuntoEncuentro();
	    return info;
	}
    
    public abstract void inscribir(Usuario usuario, Excursion excursion);
}
