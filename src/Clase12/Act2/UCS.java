package Clase12.Act2;

import java.util.*;

public class UCS {
    private final Map<String, List<NodoDestino>> graph = new HashMap<>();

    // Agregar conexiones al grafo
    public void addEdge(String from, String to, int costo) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(new NodoDestino(to, costo));
    }

    // Método para realizar la búsqueda UCS
    public int uniformCostSearch(String start, String goal) {
        PriorityQueue<NodoDestino> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.costo));
        priorityQueue.add(new NodoDestino(start, 0));
        Set<String> visited = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            NodoDestino current = priorityQueue.poll();

            // Si alcanzamos el nodo objetivo, retornamos el costoo
            if (current.viaje.equals(goal)) {
                return current.costo;
            }

            // Si ya hemos visitado este nodo, lo ignoramos
            if (visited.contains(current.viaje)) continue;
            visited.add(current.viaje);

            // Explorar vecinos
            for (NodoDestino neighbor : graph.getOrDefault(current.viaje, new ArrayList<>())) {
                if (!visited.contains(neighbor.viaje)) {
                    priorityQueue.add(new NodoDestino(neighbor.viaje, current.costo + neighbor.costo));
                }
            }
        }

        return -1; // Retorna -1 si no se encuentra un camino
    }
}