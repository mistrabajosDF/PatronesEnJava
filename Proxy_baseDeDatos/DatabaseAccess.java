package P2_E17;

/*
 * Acceder a una base de datos que contiene información sobre cómics. Este acceso está dado por el comportamiento de la clase DatabaseRealAccess con el siguiente
protocolo.
public interface DatabaseAccess {
public int insertNewRow(List<String> rowData);
public Collection<String> getSearchResults(String queryString);
} 

Se recibe una implementación prototípica de la clase DatabaseRealAccess (ver material extra) que simula el uso de una base datos de la
siguiente forma (mire el código y los tests para entender cómo está implementada).
// Instancia una base de datos que posee dos filas
database = new DatabaseRealAccess();// Retorna el siguiente arreglo: ['Spiderman' 'Marvel'].
database.getSearchResults("select * from comics where id=1");
// Retorna 3, que es el id que se le asigna
database.insertNewRow(Arrays.asList("Patoruzú", "La flor"));
// Retorna el siguiente arreglo: ['Patoruzú', 'La flor'], ya que lo insertó antes
database.getSearchResults("select * from comics where id=3");

Proveer una solución que permita brindar protección al acceso a la base de datos de forma que lo puedan realizar solamente
usuarios que se hayan autenticado previamente. 
 */

import java.util.Collection;
import java.util.List;

public interface DatabaseAccess {
	public abstract Collection<String> getSearchResults(String queryString);

	public abstract int insertNewRow(List<String> rowData);
}