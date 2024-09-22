package Clase7.Act2;

public class Grafo {
    private static final int INF = Integer.MAX_VALUE;
    private int[][] dist;
    private int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        dist = new int[numVertices][numVertices];

        // Inicializar la matriz de distancias
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = INF;
                }
            }
        }
    }

    public void agregarArista(int origen, int destino, int tiempo) {
        dist[origen][destino] = tiempo;
    }

    public void floydWarshall() {
        int V = numVertices;
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Detectar ciclos negativos
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                System.out.println("El grafo contiene un ciclo negativo.");
                return;
            }
        }

        // Imprimir la matriz de distancias
        printSolution(dist, V);
    }

    void printSolution(int dist[][], int V) {
        System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(4);

        
        grafo.agregarArista(0, 1, 5);
        grafo.agregarArista(0, 3, 10);
        grafo.agregarArista(1, 2, 3);
        grafo.agregarArista(2, 3, 1);
        grafo.agregarArista(3, 1, -2);

        
        grafo.floydWarshall();
    }
}
