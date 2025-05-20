public class Grafo {
    private final int INF = 99999; // infinito para representar la ausencia de conexión
    private int[][] distancias;
    private int[][] camino;
    private String[] nombresNodos;
    private int numNodos;

    public Grafo(int numNodos) {
        this.numNodos = numNodos;
        distancias = new int[numNodos][numNodos];
        camino = new int[numNodos][numNodos];
        nombresNodos = new String[numNodos];

        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                if (i == j) distancias[i][j] = 0;
                else distancias[i][j] = INF;
                camino[i][j] = -1;
            }
        }
    }

    public void setNombreNodo(int indice, String nombre) {
        nombresNodos[indice] = nombre;
    }

    public void agregarArco(int origen, int destino, int peso) {
        distancias[origen][destino] = peso;
        camino[origen][destino] = destino;
    }

    public void eliminarArco(int origen, int destino) {
        distancias[origen][destino] = INF;
        camino[origen][destino] = -1;
    }

    public void floydWarshall() {
        for (int k = 0; k < numNodos; k++) {
            for (int i = 0; i < numNodos; i++) {
                for (int j = 0; j < numNodos; j++) {
                    if (distancias[i][k] + distancias[k][j] < distancias[i][j]) {
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                        camino[i][j] = camino[i][k];
                    }
                }
            }
        }
    }

    public void imprimirRuta(int origen, int destino) {
        if (camino[origen][destino] == -1) {
            System.out.println("No hay ruta");
            return;
        }
        System.out.print(nombresNodos[origen]);
        while (origen != destino) {
            origen = camino[origen][destino];
            System.out.print(" -> " + nombresNodos[origen]);
        }
        System.out.println();
    }

    public void imprimirMatrizDistancias() {
        System.out.println("\nMatriz de distancias:");
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                if (distancias[i][j] == INF) System.out.print("INF ");
                else System.out.print(distancias[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String obtenerCentroGrafo() {
        int[] excentricidades = new int[numNodos];
        for (int i = 0; i < numNodos; i++) {
            int max = 0;
            for (int j = 0; j < numNodos; j++) {
                if (distancias[i][j] != INF && distancias[i][j] > max) {
                    max = distancias[i][j];
                }
            }
            excentricidades[i] = max;
        }

        int centro = 0;
        for (int i = 1; i < numNodos; i++) {
            if (excentricidades[i] < excentricidades[centro]) {
                centro = i;
            }
        }
        return nombresNodos[centro];
    }
}
