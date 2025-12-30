package P2_E6;

public class EstadoCompleta extends EstadoExcursion {

    public EstadoCompleta() {
    }

    @Override
    public void inscribir(Usuario usuario, Excursion excursion) {
        excursion.agregarEspera(usuario);
    }

    @Override
    public String obtenerInformacion(Excursion excursion) {
        return super.obtenerInformacion(excursion) + " | COMPLETA";
    }
}
