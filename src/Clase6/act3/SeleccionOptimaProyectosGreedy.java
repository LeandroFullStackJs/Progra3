package Clase6.act3;

import java.util.Arrays;
import java.util.Comparator;

public class SeleccionOptimaProyectosGreedy {
    //una clase que voy a usar para ordenarlo
    static class Proyecto {
        int costo;
        int beneficio;

        public Proyecto(int costo, int beneficio) {
            this.costo = costo;
            this.beneficio = beneficio;
        }

        @Override
        public String toString() {
            return "Proyecto{" +
                    "costo=" + costo +
                    ", beneficio=" + beneficio +
                    '}';
        }
    }
    
    // Método principal
    public static void main(String[] args) {
        //parametros iniciales
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        // Mostrar el resultado
        System.out.println("el beneficio maximo de un presupuesto de " + presupuesto + " es: " + optimizarPresupuesto(costos, beneficios, presupuesto));
    }

    public static int optimizarPresupuesto(int[] costos, int[] beneficios, int presupuesto) {
        //uso una arr de proyectos para ordenar los proyectos en base al beneficio
        Proyecto[] proyectos = new Proyecto[costos.length];
        
        for (int k = 0; k < costos.length; k++) {
            proyectos[k] = new Proyecto(costos[k], beneficios[k]);
        }
        
        Arrays.sort(proyectos, Comparator.comparingDouble(j -> -j.beneficio));

        int beneficioTotal = 0;
        int costoTotal = 0;

        // Seleccionar proyectos mientras el presupuesto lo permita
        for (Proyecto proyecto : proyectos) {
            if (costoTotal + proyecto.costo <= presupuesto) {
                costoTotal += proyecto.costo;
                beneficioTotal += proyecto.beneficio;
            }
        }

        // Retornar el beneficio total
        return beneficioTotal;
    }
}
