import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GrafoTest {
    private Grafo grafo;

    @BeforeEach
    public void setUp() {
        grafo = new Grafo(5);
        grafo.setNombreNodo(0, "Ciudad de Guatemala");
        grafo.setNombreNodo(1, "Zacapa");
        grafo.setNombreNodo(2, "Chiquimula");
        grafo.setNombreNodo(3, "Quetzaltenango");
        grafo.setNombreNodo(4, "Cobán");
    }

    @Test
    public void testAgregarArco() {
        grafo.agregarArco(0, 1, 150); 
        assertEquals(150, grafo.getDistancia(0, 1), "El peso del arco no es correcto");
    }

    @Test
    public void testEliminarArco() {
        grafo.agregarArco(0, 1, 150);
        grafo.eliminarArco(0, 1); 
        assertEquals(9999999, grafo.getDistancia(0, 1), "El arco no fue eliminado correctamente");
    }

    @Test
    public void testFloydWarshall() {
        // Agregar arcos
        grafo.agregarArco(0, 1, 150);
        grafo.agregarArco(1, 2, 60);
        grafo.agregarArco(0, 3, 200);
        grafo.agregarArco(3, 4, 180);
        grafo.agregarArco(4, 2, 120);

        grafo.floydWarshall(); 
        assertEquals(210, grafo.getDistancia(0, 2), "La distancia más corta calculada no es correcta");
    }

    @Test
    public void testObtenerCentroGrafo() {
        grafo.agregarArco(0, 1, 3);
        grafo.agregarArco(0, 3, 7);
        grafo.agregarArco(1, 2, 1);
        grafo.agregarArco(1, 4, 1);
        grafo.agregarArco(2, 3, 8);
        grafo.agregarArco(3, 4, 3);
        grafo.agregarArco(4, 1, 4);

        grafo.floydWarshall(); 
        String centro = grafo.obtenerCentroGrafo();
        assertEquals("Ciudad de Guatemala", centro, "El centro del grafo no es correcto");
    }
}
