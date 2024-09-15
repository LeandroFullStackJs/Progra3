package Clase5.Act2;

public class Grafo {
    private int[][] matrizAdyacencia;
    private int numVertices;

    // Constructor para inicializar el grafo
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        matrizAdyacencia = new int[numVertices][numVertices];
    }

    // Método para agregar una arista
    public void agregarArista(int desde, int hasta) {
        matrizAdyacencia[desde][hasta] = 1;
    }

    // Método para eliminar una arista
    public void eliminarArista(int desde, int hasta) {
        matrizAdyacencia[desde][hasta] = 0;
    }

    // Método para verificar si existe una arista
    public boolean existeArista(int desde, int hasta) {
        return matrizAdyacencia[desde][hasta] == 1;
    }

    // Método para listar todos los vértices adyacentes
    public void listarAdyacentes(int vertice) {
        System.out.print("Vértices adyacentes a " + vertice + ": ");
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[vertice][i] == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Método para contar el grado de salida de un vértice
    public int gradoSalida(int vertice) {
        int count = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[vertice][i] == 1) {
                count++;
            }
        }
        return count;
    }

    // Método para contar el grado de entrada de un vértice
    public int gradoEntrada(int vertice) {
        int count = 0;
        for (int i = 0; i < numVertices; i++) {
            if (matrizAdyacencia[i][vertice] == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(4);

        // Agregar aristas
        grafo.agregarArista(0, 1); // A - B
        grafo.agregarArista(0, 2); // A - C
        grafo.agregarArista(1, 3); // B - D
        grafo.agregarArista(2, 3); // C - D

        // Listar adyacentes
        grafo.listarAdyacentes(0); // Debería imprimir: 1 2
        grafo.listarAdyacentes(1); // Debería imprimir: 3

        // Verificar aristas
        System.out.println("Arista entre 0 y 1: " + grafo.existeArista(0, 1)); // Debería imprimir: true
        System.out.println("Arista entre 1 y 2: " + grafo.existeArista(1, 2)); // Debería imprimir: false

        // Contar grados
        System.out.println("Grado de salida de 0: " + grafo.gradoSalida(0)); // Debería imprimir: 2
        System.out.println("Grado de entrada de 3: " + grafo.gradoEntrada(3)); // Debería imprimir: 2
    }

}
