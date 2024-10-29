package Clase12.Act2;

import java.util.*;

public class SistemaSeleccionViajes {
    public static void main(String[] args) {
        UCS ucs = new UCS();

        ucs.addEdge("viajeARG", "viajeBR", 5);
        ucs.addEdge("viajeARG", "viajeURU", 2);
        ucs.addEdge("viajeURU", "viajeBR", 2);
        ucs.addEdge("viajeCL", "viajeARG", 4);
        ucs.addEdge("viajeESP", "viajeBR", 9);
        ucs.addEdge("viajeCOL", "viajeCL", 3);
        ucs.addEdge("viajeCL", "viajeBR", 7);

        //el obj es llegar a brasil
        String ubicacionOrigen = "viajeARG";
        String ubicacionDestino = "viajeBR";
        int costoTotal = ucs.uniformCostSearch(ubicacionOrigen, ubicacionDestino);

            System.out.println(
                    costoTotal != -1 ?
                    "El costo mínimo desde " + ubicacionOrigen + " hasta " + ubicacionDestino + " es: " + costoTotal
                    :
                    "No se encontró un camino desde " + ubicacionOrigen + " hasta " + ubicacionDestino
            );

    }
}
