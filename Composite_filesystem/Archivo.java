package P2_E12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Archivo extends ElementoFS {
    private int tamano;

    public Archivo(String nombre, LocalDate fechaCreacion, int tamano) {
        super(nombre, fechaCreacion);
        this.tamano = tamano;
    }

    @Override
    public int tamano() {
        return tamano;
    }

    @Override
    public Archivo archivoMasGrande() {
        return this;
    }

    @Override
    public Archivo archivoMasNuevo() {
        return this;
    }

    @Override
    public ElementoFS buscar(String nombre) {
        return this.nombre.equals(nombre) ? this : null;
    }

    @Override //Devuelve tipo lista para coincidir con el tipo que devuelve directorio
    public List<ElementoFS> buscarTodos(String nombre) {
        List<ElementoFS> resultado = new ArrayList<>();
        if (this.nombre.equals(nombre)) {
            resultado.add(this);
        }
        return resultado;
    }

    @Override
    public String listadoDeContenido(String path) {
        return path + "/" + this.nombre + "\n";
    }
}
