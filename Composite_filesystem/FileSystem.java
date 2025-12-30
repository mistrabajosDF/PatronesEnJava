package P2_E12;
/*
 * Un File System es un componente que forma parte del sistema operativo con un directorio raíz.
Sus elementos pueden ser directorios o archivos. Los archivos contienen datos y los directorios contienen archivos u otros directorios. 
De cada archivo se conoce el nombre, fecha de creación y tamaño en bytes. De cada directorio se conoce el nombre,
fecha de creación y contenido (el tamaño es siempre la cantidad inicial de 32kb más la suma del tamaño de su contenido). 
Modele el file system y provea la siguiente funcionalidad:

public class FileSystem {
public int tamanoTotalOcupado()
public Archivo archivoMasGrande()
public Archivo archivoMasNuevo()
public ?? buscar(String nombre)
public List<??> buscarTodos(String nombre)
public String listadoDeContenido()
} 

Diseñe, implemente y ejecute test cases para verificar el funcionamiento.
 */

import java.util.List;

public class FileSystem {
    private Directorio raiz;

    public FileSystem(Directorio raiz) {
        this.raiz = raiz;
    }

    public int tamanoTotalOcupado() {
        return raiz.tamano();
    }

    public Archivo archivoMasGrande() {
        return raiz.archivoMasGrande();
    }

    public Archivo archivoMasNuevo() {
        return raiz.archivoMasNuevo();
    }

    public ElementoFS buscar(String nombre) {
        return raiz.buscar(nombre);
    }

    public List<ElementoFS> buscarTodos(String nombre) {
        return raiz.buscarTodos(nombre);
    }

    public String listadoDeContenido() {
        return raiz.listadoDeContenido("");
    }
}
