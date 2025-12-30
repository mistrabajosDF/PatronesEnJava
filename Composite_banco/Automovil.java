package P2_E14;

class Automovil extends Prenda {
    private String modelo;
    private int antiguedad;
    private double costo0km;
    
    private static final double LIQUIDEZ = 0.7;

    public Automovil(String modelo, int antiguedad, double costo0km) {
    	super(LIQUIDEZ);
    	this.modelo = modelo;
        this.antiguedad = antiguedad;
        this.costo0km = costo0km;
    }

    @Override
    public double valor() {
        double valorCalculado = costo0km - ( costo0km / 100 * (10 * antiguedad)); //descuenta 10% por año
        double valorMinimo = costo0km * 0.3; // no baja de 30%
        return Math.max(valorCalculado, valorMinimo);
    }

}
