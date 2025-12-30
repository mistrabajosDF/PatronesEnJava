package P2_E11;

/*
 * Un objeto Topografía representa la distribución de agua y tierra de una celda satelital, la cual está formada por porciones de “agua” y de “tierra”.
Una topografía mixta está formada por partes de agua y partes de tierra (4 partes en total).
Estas a su vez, podrían descomponerse en 4 más y así siguiendo.
La proporción de agua de una topografía sólo agua es 1, de una sólo tierra es 0; la de una compuesta está dadapor la suma de la proporción de agua de sus componentes dividida por 4. 

Implemente las clases necesarias para:
a. crear Topografías,
b. calcular su proporción de agua y tierra,
c. comparar igualdad entre topografías. Dos topografías son iguales si tienen exactamente la misma composición. Es decir, son iguales las proporciones
de agua y tierra, y además, para aquellas que son mixtas, la disposición de sus partes es igual.
d. test para probar la funcionalidad implementada.
 */

public abstract class Topografia {
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) return false;
        return this.equalsTopografia((Topografia) obj); //esto lo definen las hijas
    }

    protected abstract boolean equalsTopografia(Topografia otra);

    protected abstract double proporcionAgua();
}
