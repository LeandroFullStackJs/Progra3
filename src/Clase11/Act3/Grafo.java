package Clase11.Act3;
import java.util.*;

public class Grafo {
    private Map<Integer, Almacen> almacenes;
    private Map<Integer, List<Integer>> adjList;

    public Grafo() {
        almacenes = new HashMap<>();
        adjList = new HashMap<>();
    }

    public void agregarAlmacen(Almacen almacen) {
        almacenes.put(almacen.getId(), almacen);
        adjList.put(almacen.getId(), new ArrayList<>());
    }

    public void conectarAlmacenes(int origen, int destino) {
        if (almacenes.containsKey(origen) && almacenes.containsKey(destino)) {
            adjList.get(origen).add(destino);
        }
    }

    public void DFS(int inicio) {
        boolean[] visitado = new boolean[almacenes.size()];
        DFSUtil(inicio, visitado);
    }

    private void DFSUtil(int v, boolean[] visitado) {
        visitado[v] = true;
        System.out.print(v + " ");

        for (int n : adjList.get(v)) {
            if (!visitado[n]) {
                DFSUtil(n, visitado);
            }
        }
    }

    public void BFS(int inicio) {
        boolean[] visitado = new boolean[almacenes.size()];
        LinkedList<Integer> cola = new LinkedList<>();

        visitado[inicio] = true;
        cola.add(inicio);

        while (!cola.isEmpty()) {
            int v = cola.poll();
            System.out.print(v + " ");

            for (int n : adjList.get(v)) {
                if (!visitado[n]) {
                    visitado[n] = true;
                    cola.add(n);
                }
            }
        }
    }
}