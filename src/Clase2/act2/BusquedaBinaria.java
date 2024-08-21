package Clase2.act2;



public class BusquedaBinaria {

    public static int busquedaBinaria(int[] arreglo, int objetivo) {
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
