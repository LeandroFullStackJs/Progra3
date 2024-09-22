package Clase7.Act3;
    import java.util.Scanner;

    public class Grafo {
        private static final int INF = 99999;  // Usamos un valor grande para representar el infinito
        private int[][] dist;
        private int[][] P; // Matriz de recuperación de caminos
        private int numVertices;
    
        public Grafo(int numVertices) {
            this.numVertices = numVertices;
            dist = new int[numVertices][numVertices];
            P = new int[numVertices][numVertices];
    
            // Inicializar la matriz de distancias y la matriz de predecesores
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (i == j) {
                        dist[i][j] = 0;
                    } else {
                        dist[i][j] = INF;
                    }
                    P[i][j] = -1;
                }
            }
        }
    
        public void agregarArista(int origen, int destino, int tiempo) {
            dist[origen][destino] = tiempo;
            P[origen][destino] = origen;
        }
    
        public void floydWarshall() {
            int V = numVertices;
            for (int k = 0; k < V; k++) {
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            P[i][j] = P[k][j];
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
        }
    
        public void printSolution() {
            System.out.println("Matriz de distancias más cortas entre cada par de vértices:");
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (dist[i][j] == INF)
                        System.out.print("INF ");
                    else
                        System.out.print(dist[i][j] + "   ");
                }
                System.out.println();
            }
        }
    
        public void printPath(int origen, int destino) {
            if (P[origen][destino] == -1) {
                System.out.println("No hay camino disponible.");
                return;
            }
            System.out.print("El camino más corto desde " + origen + " hasta " + destino + " es: ");
            imprimirCaminoRecursivo(origen, destino);
            System.out.println(destino);
            System.out.println("El costo del camino más corto es: " + dist[origen][destino]);
        }
    
        private void imprimirCaminoRecursivo(int origen, int destino) {
            if (P[origen][destino] == origen) {
                System.out.print(origen + " -> ");
                return;
            }
            imprimirCaminoRecursivo(origen, P[origen][destino]);
            System.out.print(P[origen][destino] + " -> ");
        }
    
        public static void main(String[] args) {
            Grafo grafo = new Grafo(4);
    
            
            grafo.agregarArista(0, 1, 5);
            grafo.agregarArista(0, 3, 10);
            grafo.agregarArista(1, 2, 3);
            grafo.agregarArista(2, 3, 1);
            grafo.agregarArista(3, 1, -2);
    
           
            grafo.floydWarshall();
    
            // Imprimir la matriz de distancias
            grafo.printSolution();
    
            try (
            // Pedir al usuario que ingrese el origen y destino
            Scanner scanner = new Scanner(System.in)) {
                System.out.print("Ingrese el vértice de origen: ");
                int origen = scanner.nextInt();
                System.out.print("Ingrese el vértice de destino: ");
                int destino = scanner.nextInt();
    
                // Imprimir el camino más corto
                grafo.printPath(origen, destino);
            }
        }
    }