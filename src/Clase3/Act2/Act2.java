package Clase3.Act2;

public class Act2 {

    public static class Result {
        int mayor;
        int segundoMayor;

        public Result(int mayor, int segundoMayor) {
            this.mayor = mayor;
            this.segundoMayor = segundoMayor;
        }
    }

    public static Result encontrarDosMayores(int[] lista) {
        if (lista.length < 2) {
            throw new IllegalArgumentException("La lista debe contener al menos dos elementos");
        }
        return encontrarDosMayoresRec(lista, 0, lista.length - 1);
    }

    private static Result encontrarDosMayoresRec(int[] lista, int inicio, int fin) {
        if (inicio == fin) {
            throw new IllegalArgumentException("No hay un segundo mayor elemento");
        }
        if (fin - inicio == 1) {
            int mayor = Math.max(lista[inicio], lista[fin]);
            int segundoMayor = Math.min(lista[inicio], lista[fin]);
            return new Result(mayor, segundoMayor); // Dos elementos
        }

        int mid = (inicio + fin) / 2;
        Result izquierda = encontrarDosMayoresRec(lista, inicio, mid);
        Result derecha = encontrarDosMayoresRec(lista, mid + 1, fin);

        int mayor, segundoMayor;
        if (izquierda.mayor > derecha.mayor) {
            mayor = izquierda.mayor;
            segundoMayor = Math.max(izquierda.segundoMayor, derecha.mayor);
        } else {
            mayor = derecha.mayor;
            segundoMayor = Math.max(derecha.segundoMayor, izquierda.mayor);
        }

        return new Result(mayor, segundoMayor);
    }

    public static void main(String[] args) {
        int[] lista = {3, 5, 1, 9, 7, 8, 2, 6};
        try {
            Result resultado = encontrarDosMayores(lista);
            System.out.println("El mayor es: " + resultado.mayor);
            System.out.println("El segundo mayor es: " + resultado.segundoMayor);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
/*  Análisis de Recurrencia:

División: Cada llamada recursiva divide la lista en dos partes iguales.
Conquista: Comparar los resultados de las dos sublistas.
Recurrencia: T(n) = 2T(n/2) + O(1)
Análisis Inductivo:
Para una lista de tamaño 1, la complejidad es O(1).
Para una lista de tamaño n, se divide en dos sublistas de tamaño n/2, y se realizan dos llamadas recursivas.
La comparación final toma O(1) tiempo.
Por lo tanto, la complejidad total es O(n log n). */
