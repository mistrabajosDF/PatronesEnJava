package P2_E14;

public abstract class Prenda {

    private final double coeficienteLiquidez;

    protected Prenda(double coeficienteLiquidez) {
        this.coeficienteLiquidez = coeficienteLiquidez;
    }

    public double valorPrendario() {
        return valor() * coeficienteLiquidez;
    }

    protected abstract double valor();
}
