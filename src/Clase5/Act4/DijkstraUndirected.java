package Clase5.Act4;
import java.util.*;

public class DijkstraUndirected {

	static class Edge {
		int target;
		int weight;

		Edge(int target, int weight) {
			this.target = target;
			this.weight = weight;
		}
	}

	static class Graph {
		int vertices;
		List<List<Edge>> adjList;

		Graph(int vertices) {
			this.vertices = vertices;
			adjList = new ArrayList<>(vertices);
			for (int i = 0; i < vertices; i++) {
				adjList.add(new ArrayList<>());
			}
		}

		// Método para agregar aristas para grafos no dirigidos
		void addEdge(int source, int target, int weight) {
			adjList.get(source).add(new Edge(target, weight));
			adjList.get(target).add(new Edge(source, weight)); // Esto asegura que la arista es bidireccional
		}

		void dijkstra(int startVertex) {
			int[] distances = new int[vertices];
			Arrays.fill(distances, Integer.MAX_VALUE);
			distances[startVertex] = 0;

			PriorityQueue<Edge> pq = new PriorityQueue<>(vertices, Comparator.comparingInt(e -> e.weight));
			pq.add(new Edge(startVertex, 0));

			boolean[] visited = new boolean[vertices];

			while (!pq.isEmpty()) {
				int u = pq.poll().target;

				if (visited[u]) continue;
				visited[u] = true;

				for (Edge edge : adjList.get(u)) {
					int v = edge.target;
					int weight = edge.weight;

					if (!visited[v] && distances[u] + weight < distances[v]) {
						distances[v] = distances[u] + weight;
						pq.add(new Edge(v, distances[v]));
					}
				}
			}

			printSolution(distances, startVertex);
		}

		void printSolution(int[] distances, int startVertex) {
			System.out.println("Distancia desde el vértice " + startVertex);
			for (int i = 0; i < vertices; i++) {
				System.out.println("Hasta " + i + " es " + distances[i]);
			}
		}
	}
}
