package P2_E2;

/*
Sea una empresa que paga sueldos a sus empleados, los cuales están organizados en tres tipos: Temporarios, Pasantes y Planta. El sueldo se compone de 3 elementos: sueldo
básico, adicionales y descuentos.
		Temporario 					Pasante 					Planta
básico 		$ 20.000 + cantidad de horas que trabajó * $ 300.	$20.000 					$ 50.000
adicional 		$5.000 si está casado, $2.000 por cada hijo		$2.000 por examen que rindió		$5.000 si estácasado, $2.000 por cada hijo, $2.000 por cada año de antigüedad
descuento 	13% del sueldo básico, 5% del sueldo adicional		13% del sueldo básico, 5% del sueldo adicional	13% del sueldo básico, 5% del sueldo adicional
Tareas:
Diseñe la jerarquía de Empleados de forma tal que cualquier empleado puede responder al mensaje #sueldo.
Desarrolle los test cases necesarios para probar todos los casos posibles.
 */
public abstract class Empleado {
	protected boolean casado;
	protected int cantidadHijos;
    
    protected double sueldo() {
        return this.sueldoBasico() + this.adicional() - this.descuento(this.sueldoBasico(), this.adicional());
    }

    protected double sueldoBasico() {
        return 20000;
    }
    
    protected double adicional() {
    	return (casado ? 5000 : 0) + cantidadHijos * 2000;
    }

    protected double descuento(double basico, double adicional) {
        return basico * 0.13 + adicional * 0.05;
    }
}
