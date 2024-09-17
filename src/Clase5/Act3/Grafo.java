package Clase5.Act3;
import java.util.*;

class Arista {
    int destino;
    int costo;

    public Arista(int destino, int costo) {
        this.destino = destino;
        this.costo = costo;
    }
}

public class Grafo {
    private List<List<int[]>> listaAdyacencia;
    private int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino, int costo) {
        listaAdyacencia.get(origen).add(new int[]{destino, costo});
        listaAdyacencia.get(destino).add(new int[]{origen, costo}); // Grafo no dirigido
    }

    public List<List<int[]>> getListaAdyacencia() {
        return listaAdyacencia;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);

        // Agregar aristas con costos
        grafo.agregarArista(0, 1, 10);
        grafo.agregarArista(0, 2, 20);
        grafo.agregarArista(1, 2, 30);
        grafo.agregarArista(1, 3, 5);
        grafo.agregarArista(2, 3, 15);
        grafo.agregarArista(3, 4, 10);

        // Aplicar el algoritmo de Prim
        PrimAlgorithm.primMST(grafo.getNumVertices(), grafo.getListaAdyacencia());
    }
}
