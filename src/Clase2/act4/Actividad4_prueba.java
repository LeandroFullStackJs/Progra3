package Clase2.act4;

import Clase2.act3.QuickSort;

import java.util.Arrays;

public class Actividad4_prueba {
    public static void main(String []args){

        int[] listaDeNrosDesordenados = new int[] {9, 1, 8, 2, 7, 3, 6, 4, 5};
        System.out.println("lista desordenada: " + Arrays.toString(listaDeNrosDesordenados));
        QuickSort.quickSort(listaDeNrosDesordenados);
        System.out.println("lista desordenada luego del merge sort: " + Arrays.toString(listaDeNrosDesordenados));

    }
}
