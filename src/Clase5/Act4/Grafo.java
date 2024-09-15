package Clase5.Act4;
import java.util.*;

class Arista {
	int destino;
	int tiempo;

	public Arista(int destino, int tiempo) {
		this.destino = destino;
		this.tiempo = tiempo;
	}
}

public class Grafo {
	private List<List<Arista>> listaAdyacencia;
	private int numVertices;

	public Grafo(int numVertices) {
		this.numVertices = numVertices;
		listaAdyacencia = new ArrayList<>();
		for (int i = 0; i < numVertices; i++) {
			listaAdyacencia.add(new ArrayList<>());
		}
	}

	public void agregarArista(int origen, int destino, int tiempo) {
		listaAdyacencia.get(origen).add(new Arista(destino, tiempo));
		listaAdyacencia.get(destino).add(new Arista(origen, tiempo)); // Grafo no dirigido
	}

	public List<List<Arista>> getListaAdyacencia() {
		return listaAdyacencia;
	}

	public int getNumVertices() {
		return numVertices;
	}

	public static void main(String[] args) {
		Grafo grafo = new Grafo(5);

		// Agregar aristas con tiempos de viaje
		grafo.agregarArista(0, 1, 10);
		grafo.agregarArista(0, 2, 20);
		grafo.agregarArista(1, 2, 30);
		grafo.agregarArista(1, 3, 5);
		grafo.agregarArista(2, 3, 15);
		grafo.agregarArista(3, 4, 10);

		// Aplicar el algoritmo de Dijkstra
		DijkstraUndirected.Graph dijkstraGraph = new DijkstraUndirected.Graph(grafo.getNumVertices());
		for (int i = 0; i < grafo.getNumVertices(); i++) {
			for (Arista arista : grafo.getListaAdyacencia().get(i)) {
				dijkstraGraph.addEdge(i, arista.destino, arista.tiempo);
			}
		}
		dijkstraGraph.dijkstra(0); // Centro de distribución principal es el vértice 0
	}
}
