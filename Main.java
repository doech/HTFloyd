public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);

        // nombres de ciudades
        grafo.setNombreNodo(0, "Ciudad de Guatemala"); // A
        grafo.setNombreNodo(1, "Zacapa");              // B
        grafo.setNombreNodo(2, "Chiquimula");          // C
        grafo.setNombreNodo(3, "Quetzaltenango");      // D
        grafo.setNombreNodo(4, "Cobán");               // E

        // conexiones (ejemplo con distancias inventadas)
        grafo.agregarArco(0, 1, 3); // A -> B
        grafo.agregarArco(0, 3, 7); // A -> D
        grafo.agregarArco(1, 2, 1); // B -> C
        grafo.agregarArco(1, 4, 1); // B -> E
        grafo.agregarArco(2, 3, 8); // C -> D
        grafo.agregarArco(3, 4, 3); // D -> E
        grafo.agregarArco(4, 1, 4); // E -> A
        grafo.floydWarshall();
        grafo.imprimirMatrizDistancias();

        // mostrar ruta de A (0) a C (2)
        System.out.print("Ruta más corta de Ciudad de Guatemala a Chiquimula: ");
        grafo.imprimirRuta(0, 2);
        System.out.println("Centro del grafo: " + grafo.obtenerCentroGrafo());
    }
}
