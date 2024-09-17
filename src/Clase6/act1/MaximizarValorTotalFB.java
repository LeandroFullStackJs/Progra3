package Clase6.act1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximizarValorTotalFB {
    // Clase que representa un Objeto con costo y rendimiento.
    static class Objeto {
        int peso;
        int valor;

        public Objeto(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "Objeto{" +
                    "peso=" + peso +
                    ", valor=" + valor +
                    '}';
        }
    }

    // Método principal
    public static void main(String[] args) {
        // Definir los Objetos
        Objeto[] Objetos = {
                new Objeto(3, 4),  // Objeto 1
                new Objeto(4, 5),
                new Objeto(2, 3)
        };

        int pesoTotalDeMochila = 8;  // pesoTotalDeMochila máximo

        // Llamamos a la función que realiza la búsqueda de la mejor combinación
        Mochila mejorResultado = mejorCombinacion(Objetos, pesoTotalDeMochila);

        // Mostrar el resultado
        System.out.println("Valor máximo: " + mejorResultado.valorTotal);
        System.out.println("Peso total: " + mejorResultado.pesoTotal);
        System.out.println("Objetos dentro de la mochila: " + mejorResultado.objDentroDeLaMochila);
    }

    // Clase para almacenar el resultado de la mejor combinación
    static class Mochila {
        int valorTotal;
        int pesoTotal;
        ArrayList<Objeto> objDentroDeLaMochila;

        public Mochila(int valorTotal, int pesoTotal, ArrayList<Objeto> objDentroDeLaMochila) {
            this.valorTotal = valorTotal;
            this.pesoTotal = pesoTotal;
            this.objDentroDeLaMochila = objDentroDeLaMochila;
        }
    }

    // Función para encontrar la mejor combinación
    static Mochila mejorCombinacion(Objeto[] Objetos, int pesoTotalDeMochila) {
        int n = Objetos.length;
        int mejorRendimiento = 0;
        int mejorCosto = 0;
        ArrayList<Objeto> mejoresObjs = new ArrayList<>();

        // Probar todas las combinaciones posibles (2^n combinaciones)
        for (int i = 0; i < (1 << n); i++) {  // "1 << n" es 2^n
            int costoTotal = 0;
            int rendimientoTotal = 0;
            ArrayList<Objeto> objsTotales = new ArrayList<>();

            // Recorremos cada bit de la combinación actual
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {  // Si el bit j está activado en i
                    costoTotal += Objetos[j].peso;
                    rendimientoTotal += Objetos[j].valor;
                    objsTotales.add(Objetos[j]);
                }
            }

            // Verificar si el costo total no excede el pesoTotalDeMochila y si el rendimiento es mejor
            if (costoTotal <= pesoTotalDeMochila && rendimientoTotal > mejorRendimiento) {
                mejorRendimiento = rendimientoTotal;
                mejorCosto = costoTotal;
                mejoresObjs = objsTotales;
            }
        }

        // Retornar el mejor resultado
        return new Mochila(mejorRendimiento, mejorCosto, mejoresObjs);
    }
}
