package P2_E14;

class Inmueble extends Prenda {
    private String direccion;
    private double superficie;
    private double costoM2;
    
    private static final double LIQUIDEZ = 0.2;

    public Inmueble(String direccion, double superficie, double costoM2) {
    	super(LIQUIDEZ);
        this.direccion = direccion;
        this.superficie = superficie;
        this.costoM2 = costoM2;
    }

    public double valor() {
        return superficie * costoM2;
    }

}