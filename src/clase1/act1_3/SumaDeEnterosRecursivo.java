package clase1.act1_3;

public final class SumaDeEnterosRecursivo {
    public static int sumarEnterosRecursivamente(int nro) {
        if (nro == 0) {
            return nro;
        }
        return sumarEnterosRecursivamente(nro-1) + nro;
    }
}

// OTRA FORMA DE HACERLO : 
    // Método para realizar la búsqueda binaria
   /*  public static int busquedaBinaria(int[] arreglo, int objetivo) {
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
        */