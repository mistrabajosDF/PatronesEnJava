package P2_E12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Directorio extends ElementoFS {
    private List<ElementoFS> elementos = new ArrayList<>();

    public Directorio(String nombre, LocalDate fechaCreacion) {
        super(nombre, fechaCreacion);
    }

    public void agregarElemento(ElementoFS elemento) {
    	elementos.add(elemento);
    }

    @Override
    public int tamano() {
        return this.elementos.stream().mapToInt(e -> e.tamano()).sum() + 32;
    }

    @Override
    public Archivo archivoMasGrande() {
        return elementos.stream()
            .map(ElementoFS::archivoMasGrande)
            .max(Comparator.comparingInt(Archivo::tamano))
            .orElse(null);
    }


    @Override
    public Archivo archivoMasNuevo() {
    	return elementos.stream()
    		    .map(ElementoFS::archivoMasNuevo)
    		    .filter(Objects::nonNull)
    		    .max(Comparator.comparing(Archivo::getFechaCreacion))
    		    .orElse(null);
    }

    @Override
    public ElementoFS buscar(String nombre) {
        if (this.nombre.equals(nombre)) return this;
        return elementos.stream()
            .map(e -> e.buscar(nombre))
            .findFirst() 
            .orElse(null);
    }

    @Override 
    public List<ElementoFS> buscarTodos(String nombre) {
        List<ElementoFS> encontrados = elementos.stream()
            .map(e -> e.buscarTodos(nombre))
            .flatMap(List::stream) //hace que cada lista sola se sume a un unico stream
            .collect(Collectors.toList()); //lo vuelve a hacer lista

        if (this.nombre.equals(nombre)) {
            encontrados.add(this);
        }

        return encontrados;
    }
 
    @Override
    public String listadoDeContenido(String path) {
        return path + "/" + this.nombre + "\n" +
            elementos.stream()
                .map(e -> e.listadoDeContenido(path + "/" + this.nombre))
                .collect(Collectors.joining());
    }


}
