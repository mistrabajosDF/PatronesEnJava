package P2_E11;

import java.util.List;
import java.util.Objects;

public class TopografiaMixta extends Topografia {
    private List<Topografia> componentes;

    public TopografiaMixta(List<Topografia> componentes) {
        if (componentes.size() != 4)
            throw new IllegalArgumentException("Una topografía mixta debe tener 4 componentes.");
        this.componentes = componentes; //queda apuntando a la misma que recibio
    }

    @Override
    public double proporcionAgua() {
        return componentes.stream()
                .mapToDouble(Topografia::proporcionAgua)
                .sum() / 4;
    }

    @Override
    protected boolean equalsTopografia(Topografia otra) {
        TopografiaMixta otraMixta = (TopografiaMixta) otra;
        return this.componentes.equals(otraMixta.componentes); //es el equals de lista
    }
}

