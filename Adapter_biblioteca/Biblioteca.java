package P2_E1;

/*Red social parecida a Twitter que debe permitir a los usuarios postear y leer mensajes de
hasta 280 caracteres. 
Debe modelar e implementar parte del sistema donde:
● Cada usuario conoce todos los tweets que hizo.
● Un tweet puede ser re-tweet de otro, y este tweet debe conocer a su tweet de origen.
● Twitter debe conocer a todos los usuarios del sistema.
● Los tweets de un usuario se deben eliminar cuando el usuario es eliminado. No
existen tweets no referenciados por un usuario.
● Los usuarios se identifican por su screenName.
● No se pueden agregar dos usuarios con el mismo screenName.
● Los tweets deben tener un texto de 1 carácter como mínimo y 280 caracteres como
máximo.
● Un re-tweet no tiene texto adicional.
 */

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
	private List<Socio> socios;
	private VoorheesExporter exporter;

	public Biblioteca() {
		socios = new ArrayList<>();
		exporter= new VoorheesExporter(); 
	}

	public void agregarSocio(Socio socio) {
		socios.add(socio);
	}

	public String exportarSocios() {
		return exporter.exportar(socios);
	}

	public VoorheesExporter getExporter() {
		return exporter;
	}

	public void setExporter(VoorheesExporter exporter) {
		this.exporter = exporter;
	}
}

