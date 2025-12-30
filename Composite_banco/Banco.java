package P2_E14;

/*
 * Un banco otorga préstamos y requiere como garantía, la consignación de bienes del deudor (prenda). Los bienes que se aceptan como prenda incluyen automóviles, inmuebles y
alquileres. Cada uno de los bienes puede calcular su valor. Además cada tipo de bien tiene un coeficiente de liquidez que expresa cuán fácil es cambiar ese bien por dinero.
			Pueden responder 				Liquidez 			Valor
Automóviles 		Modelo, Kilometraje, Costo 0km 		0.7 			Reduce 10% por cada año de antigüedad
Inmuebles 		Dirección, Superficie, Costo m2 		0.2 			Superficie * costo m2
Alquileres 		Comienzo contrato, Fin Contrato, Costo mensual 		0.9 	Meses que faltan del contrato * costo mensual

En todos los casos, el valor prendario es el resultado de multiplicar el valor y el coeficiente de liquidez.
El banco desea implementar el soporte necesario para aceptar prendas combinadas, las cuales incluyen otras prendas. El valor de una prenda combinada es la sumatoria del valor
de cada uno de los componentes mientras que el valor prendario se calcula considerando que el coeficiente de liquidez es 0.5.
 */
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Prenda> prendas = new ArrayList<>();

    public void registrarPrenda(Prenda prenda) {
        prendas.add(prenda);
    }

    public double valorTotalPrendario() {
        return prendas.stream().mapToDouble(Prenda::valorPrendario).sum();
    }

    public List<Prenda> getPrendas() {
        return prendas;
    }
}