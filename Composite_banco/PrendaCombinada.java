package P2_E14;
import java.util.*;

class PrendaCombinada extends Prenda {
    private List<Prenda> componentes = new ArrayList<>();
    
    private static final double LIQUIDEZ = 0.5;
    
    public PrendaCombinada() {
        super(LIQUIDEZ);
    }

    public void agregar(Prenda p) {
        componentes.add(p);
    }

    public double valor() {
        return componentes.stream().mapToDouble(Prenda::valor).sum();
    }

}