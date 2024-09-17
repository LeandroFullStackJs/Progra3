package Clase6.act3;

import java.util.ArrayList;

public class SeleccionOptimaProyectosFB {
    public static void main(String[] args) {
        //parametros iniciales
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        // Mostrar el resultado
        System.out.println(
                "el beneficio maximo de un presupuesto de "
                        + presupuesto + " es: " + optimizarPresupuesto(costos, beneficios, presupuesto));
    }

    // Función para encontrar la mejor combinación
    static int optimizarPresupuesto(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        int mejorbeneficio = 0;

        // Probar todas las combinaciones posibles (2^n combinaciones)
        for (int i = 0; i < (1 << n); i++) {  // "1 << n" es 2^n
            int costoTotal = 0;
            int beneficioTotal = 0;

            // Recorremos cada bit de la combinación actual
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {  // Si el bit j está activado en i
                    costoTotal += costos[j];
                    beneficioTotal += beneficios[j];
                }
            }

            // Verificar si el costo total no excede el presupuesto y si el beneficio es mejor
            if (costoTotal <= presupuesto && beneficioTotal > mejorbeneficio) {
                mejorbeneficio = beneficioTotal;
            }
        }

        // Retornar el mejor resultado
        return mejorbeneficio;
    }
}
