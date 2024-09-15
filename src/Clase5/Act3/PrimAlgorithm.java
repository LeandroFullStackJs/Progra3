package Clase5.Act3;
import java.util.*;

public class PrimAlgorithm {
	private static final int INF = Integer.MAX_VALUE;

	public static void primMST(int numVertices, List<List<int[]>> graph) {
		int[] key = new int[numVertices];  // Array para almacenar el peso mínimo de la arista para incluir en el MST
		int[] parent = new int[numVertices];  // Array para almacenar el MST resultante
		boolean[] inMST = new boolean[numVertices];  // Array para rastrear los vértices incluidos en el MST

		Arrays.fill(key, INF);  // Inicializar los valores de key como infinito
		key[0] = 0;  // Empezar desde el primer vértice
		parent[0] = -1;  // El primer nodo es siempre la raíz del MST

		for (int count = 0; count < numVertices - 1; count++) {
			int u = minKey(numVertices, key, inMST);  // Seleccionar el vértice con el valor de key mínimo que aún no está incluido en el MST
			inMST[u] = true;  // Incluir u en el MST

			// Actualizar el valor de key y el índice de parent de los vértices adyacentes al vértice seleccionado
			for (int[] neighbor : graph.get(u)) {
				int v = neighbor[0];
				int weight = neighbor[1];

				// Actualizar el valor de key solo si v no está en el MST y el peso de (u, v) es menor que el valor actual de key de v
				if (!inMST[v] && weight < key[v]) {
					key[v] = weight;
					parent[v] = u;
				}
			}
		}

		printMST(parent, numVertices, graph);
	}

	private static int minKey(int numVertices, int[] key, boolean[] inMST) {
		int min = INF, minIndex = -1;

		for (int v = 0; v < numVertices; v++) {
			if (!inMST[v] && key[v] < min) {
				min = key[v];
				minIndex = v;
			}
		}

		return minIndex;
	}

	private static void printMST(int[] parent, int numVertices, List<List<int[]>> graph) {
		System.out.println("Arista \tPeso");
		int costoTotal = 0;
		for (int i = 1; i < numVertices; i++) {
			for (int[] neighbor : graph.get(i)) {
				if (neighbor[0] == parent[i]) {
					System.out.println(parent[i] + " - " + i + "\t" + neighbor[1]);
					costoTotal += neighbor[1];
				}
			}
		}
		System.out.println("Costo total: " + costoTotal);
	}
}
