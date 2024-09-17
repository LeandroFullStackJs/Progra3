package Clase6.act1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MaximizarValorTotalPD {
    // Clase que representa un Objeto con costo, rendimiento y la relación rendimiento/costo
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
    // Método principal
    public static void main(String[] args) {
        // Definir los Objetoes
        Objeto[] Objetoes = {
                new Objeto(3, 4),  // Objeto 1
                new Objeto(2, 3),
                new Objeto(4, 5)
        };

        int pesoTotalDeMochila = 8;  // pesoTotalDeMochila máximo

        // Llamar a la función que selecciona Objetoes usando el enfoque greedy
        Mochila rendimientoMaximo = seleccionGreedy(Objetoes, pesoTotalDeMochila);

        // Mostrar el resultado
        System.out.println("Valor máximo: " + rendimientoMaximo.valorTotal);
        System.out.println("Peso total: " + rendimientoMaximo.pesoTotal);
        System.out.println("Objetos dentro de la mochila: " + rendimientoMaximo.objDentroDeLaMochila);
    }

    // Función para seleccionar Objetoes usando técnica greedy
    static Mochila seleccionGreedy(Objeto[] Objetos, int pesoTotalDeMochila) {
        // Ordenamos los Objetoes por la relación peso de mayor a menor
        Arrays.sort(Objetos, Comparator.comparingInt(j -> -j.peso));

        int valorTotal = 0;
        int pesoTotal = 0;
        ArrayList<Objeto> objetosTotales = new ArrayList<>();
        ArrayList<Mochila> posiblesMochilas = new ArrayList<>();

        // Seleccionar Objetoes mientras el pesoTotalDeMochila lo permita
        for (int k = pesoTotalDeMochila; k > 0; k--) {
            for (Objeto objeto : Objetos) {
                if (pesoTotal + objeto.peso < k) {
                    pesoTotal += objeto.peso;
                    valorTotal += objeto.valor;
                    objetosTotales.add(objeto);
                }
            }
            posiblesMochilas.add(new Mochila(valorTotal, pesoTotal, objetosTotales));
        }

        // Retornar el rendimiento total
        return posiblesMochilas.get(pesoTotalDeMochila-1);
    }
}
