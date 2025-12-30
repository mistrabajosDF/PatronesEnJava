package P2_E6;

import java.util.stream.Collectors;

public class EstadoDefinitiva extends EstadoExcursion {

    public EstadoDefinitiva() {
    }

    @Override
    public void inscribir(Usuario usuario, Excursion excursion) {
        excursion.agregarInscriptos(usuario);
    }
    
    @Override
    public String obtenerInformacion(Excursion excursion) {
        int faltan = excursion.getCupoMaximo() - excursion.getInscriptos().size();
        String mails = excursion.getInscriptos().stream()
                .map(Usuario::getEmail)
                .collect(Collectors.joining(", ")); //esto queda como string
        return super.obtenerInformacion(excursion) + String.format(" | Inscriptos: %s | Faltan: %d para el máximo", mails, faltan);
    }
    
}
