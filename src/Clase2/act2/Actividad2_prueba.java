package Clase2.act2;

public class Actividad2_prueba {
    public static void main(String []args){

        int[] arreglo = {1, 3, 5, 7, 9, 11, 13}; // Arreglo ordenado
        int objetivo = 7; // Elemento a buscar
        int resultado = BusquedaBinaria.busquedaBinaria(arreglo, objetivo);

        if (resultado == -1) {
            System.out.println("Elemento no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + resultado);
        }

    }

}
