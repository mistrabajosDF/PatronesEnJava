package P2_E14;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler extends Prenda {
    private LocalDate inicio;
    private LocalDate fin;
    private double costoMensual;

    private static final double LIQUIDEZ = 0.9;
    
    public Alquiler(LocalDate inicio, LocalDate fin, double costoMensual) {
    	super(LIQUIDEZ);
        this.inicio = inicio;
        this.fin = fin;
        this.costoMensual = costoMensual;
    }

    public double valor() {
        long meses = ChronoUnit.MONTHS.between(LocalDate.now(), fin); 
        //cuántos meses hay entre hoy y el fin.
        System.out.println("Meses restantes: " + meses);
        return Math.max(0, meses) * costoMensual;
        //Si los meses restantes son negativos, pone 0 y multiplica los meses válidos por el costoMensual.
    }

}