public class Grafo {
    private final int;
    private int[][] distancias;
    private int[][] camino;
    private String[] nombresNodos;
    private int numNodos;

    public Grafo(int numNodos) {
        this.numNodos = numNodos;
        distancias = new int[numNodos][numNodos];
        camino = new int[numNodos][numNodos];
        nombresNodos = new String[numNodos];
    }
