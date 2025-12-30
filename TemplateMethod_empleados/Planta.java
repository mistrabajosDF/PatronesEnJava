package P2_E2;

public class Planta extends Empleado {
    private int aniosAntiguedad;

    public Planta(boolean casado, int cantidadHijos, int aniosAntiguedad) {
        this.casado = casado;
        this.cantidadHijos = cantidadHijos;
        this.aniosAntiguedad = aniosAntiguedad;
    }

    @Override
    protected double sueldoBasico() {
        return 50000;
    }

    @Override
    protected double adicional() {
    	return super.adicional() + aniosAntiguedad * 2000;
    }
}
