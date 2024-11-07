package Clase11.Act3;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        Almacen almacen0 = new Almacen(0, "Almacen 0");
        Almacen almacen1 = new Almacen(1, "Almacen 1");
        Almacen almacen2 = new Almacen(2, "Almacen 2");
        Almacen almacen3 = new Almacen(3, "Almacen 3");
        Almacen almacen4 = new Almacen(4, "Almacen 4");
        Almacen almacen5 = new Almacen(5, "Almacen 5");

        grafo.agregarAlmacen(almacen0);
        grafo.agregarAlmacen(almacen1);
        grafo.agregarAlmacen(almacen2);
        grafo.agregarAlmacen(almacen3);
        grafo.agregarAlmacen(almacen4);
        grafo.agregarAlmacen(almacen5);

        grafo.conectarAlmacenes(0, 1);
        grafo.conectarAlmacenes(0, 2);
        grafo.conectarAlmacenes(0, 4);
        grafo.conectarAlmacenes(1, 3);
        grafo.conectarAlmacenes(1, 5);
        grafo.conectarAlmacenes(2, 3);
        grafo.conectarAlmacenes(3, 4);

        System.out.println("Recorrido DFS empezando desde el vértice 0:");
        grafo.DFS(0);

        System.out.println("\nRecorrido BFS empezando desde el vértice 0:");
        grafo.BFS(0);
    }
}