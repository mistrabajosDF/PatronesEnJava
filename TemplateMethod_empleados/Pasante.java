package P2_E2;

public class Pasante extends Empleado {
    private int examenesRendidos;

    public Pasante(int examenesRendidos) { //no es necesario que use los atributos que hereda
        this.examenesRendidos = examenesRendidos;
    }

    @Override
    protected double adicional() {
        return examenesRendidos * 2000;
    }
}
