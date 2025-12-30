package P2_E6;

public class EstadoProvisoria extends EstadoExcursion {

    public EstadoProvisoria() {
    }
    
    @Override
    public void inscribir(Usuario usuario, Excursion excursion) {
        excursion.agregarInscriptos(usuario);
    }
    
    @Override
    public String obtenerInformacion(Excursion excursion) {
        int faltan = excursion.getCupoMinimo() - excursion.getInscriptos().size();
        return super.obtenerInformacion(excursion) + String.format(" | Faltan: %d para el mínimo", faltan);
    }
}
