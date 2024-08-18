package Clase2;



public class Actividad1 {
    public static void main(String[] args) {
    int[] arreglo = {1, 3, 5, 7, 9, 11, 13}; // Arreglo ordenado
        int objetivo = 7; // Elemento a buscar
        int resultado = busquedaBinaria(arreglo, objetivo);

        if (resultado == -1) {
            System.out.println("Elemento no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + resultado);
        }
    }

    private static int busquedaBinaria(int[] arreglo, int objetivo) {
        int izquierda = 0;
    int derecha = arreglo.length - 1;

    while (izquierda <= derecha) {
        int medio = izquierda + (derecha - izquierda) / 2;

        
        if (arreglo[medio] == objetivo) {
            return medio; // Retorna el índice del objetivo
        }
        if (arreglo[medio] < objetivo) {
            izquierda = medio + 1;
        } 
        
        else {
            derecha = medio - 1;
        }
    }

    
    return -1;
    }
}
