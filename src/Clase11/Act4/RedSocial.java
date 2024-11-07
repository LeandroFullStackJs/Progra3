package Clase11.Act4;

import java.util.*;

public class RedSocial {
    private Map<Integer, Usuario> usuarios;
    private Map<Integer, List<Integer>> adjList;

    public RedSocial() {
        usuarios = new HashMap<>();
        adjList = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
        adjList.put(usuario.getId(), new ArrayList<>());
    }

    public void conectarUsuarios(int origen, int destino) {
        if (usuarios.containsKey(origen) && usuarios.containsKey(destino)) {
            adjList.get(origen).add(destino);
            adjList.get(destino).add(origen); // Relación bidireccional
        }
    }

    public void DFS(int inicio) {
        boolean[] visitado = new boolean[usuarios.size()];
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
        boolean[] visitado = new boolean[usuarios.size()];
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