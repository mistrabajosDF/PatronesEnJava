package P2_E1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.json.JSONArray;
import org.junit.jupiter.api.Test;

public class BibliotecaTest {

    @Test
    public void testExportarSociosConDosSocios() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarSocio(new Socio("Arya Stark", "needle@stark.com", "5234-5"));
        biblioteca.agregarSocio(new Socio("Tyron Lannister", "tyron@thelannisters.com", "2345-2"));

     //ESTA LINEA ES LO QUE HACE QUE USE EL JSONADAPTER Y NO EL VOORHEESEXPORTER,
     //SE AGREGO PARA TESTEAR LA PARTE B
        biblioteca.setExporter(new JsonSimpleAdapter());
        
        //Las barras invertidas \" son caracteres de escape que indican que el siguiente carácter "
        //		+ "debe interpretarse literalmente, no como parte de la sintaxis del lenguaje.
        //Sin \", el compilador interpretaría la comilla interna como el final de la cadena, produciendo un error.
        String esperado =
            "[" +
            "{" +
                "\"nombre\": \"Arya Stark\"," +
                "\"email\": \"needle@stark.com\"," +
                "\"legajo\": \"5234-5\"" +
            "}," +
            "{" +
                "\"nombre\": \"Tyron Lannister\"," +
                "\"email\": \"tyron@thelannisters.com\"," +
                "\"legajo\": \"2345-2\"" +
            "}" +
            "]";
        
        

        //Elimina espacios y saltos para comparar por contenido
        JSONArray jsonEsperado = new JSONArray(esperado);
        JSONArray jsonResultado = new JSONArray(biblioteca.exportarSocios());

        assertEquals(jsonEsperado.toString(), jsonResultado.toString());
    }
    
    @Test
    public void testExportarSociosVacio() {
        Biblioteca biblioteca = new Biblioteca();
        String esperado = "[]";
        assertEquals(esperado, biblioteca.exportarSocios());
    }
}

