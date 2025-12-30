package P2_E12;

import java.time.LocalDate;
import java.util.List;

public abstract class ElementoFS {
    protected String nombre;
    protected LocalDate fechaCreacion;

    public ElementoFS(String nombre, LocalDate fechaCreacion) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public abstract int tamano();
    public abstract Archivo archivoMasGrande();
    public abstract Archivo archivoMasNuevo();
    public abstract ElementoFS buscar(String nombre);
    public abstract List<ElementoFS> buscarTodos(String nombre);
    public abstract String listadoDeContenido(String path);
}