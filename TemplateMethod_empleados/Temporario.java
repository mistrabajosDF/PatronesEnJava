package P2_E2;

public class Temporario extends Empleado {
    private int horasTrabajadas;

    public Temporario(int horasTrabajadas, boolean casado, int cantidadHijos) {
        this.horasTrabajadas = horasTrabajadas;
        this.casado = casado;
        this.cantidadHijos = cantidadHijos;
    }

    @Override
    protected double sueldoBasico() {
        return super.sueldoBasico() + horasTrabajadas * 300;
    }
}
