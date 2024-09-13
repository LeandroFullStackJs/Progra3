package Clase3.Act4;

import java.util.Arrays;

public class Act4 {

	public static int[] encontrarNMayores(int[] lista, int n) {
		if (lista.length <= n) {
			return lista;  // Si la lista tiene menos o igual elementos que n, devuelvo la lista completa
		}
		return encontrarNMayoresRec(lista, 0, lista.length - 1, n);
	}

	private static int[] encontrarNMayoresRec(int[] lista, int inicio, int fin, int n) {
		if (fin - inicio + 1 <= n) {
			return Arrays.copyOfRange(lista, inicio, fin + 1);  // Si la sublista tiene menos o igual elementos que n, devuelvo la sublista completa
		}

		int mid = (inicio + fin) / 2;
		int[] mayoresIzquierda = encontrarNMayoresRec(lista, inicio, mid, n);
		int[] mayoresDerecha = encontrarNMayoresRec(lista, mid + 1, fin, n);

		// Combino y ordeno los resultados de las dos sublistas 
		int[] combinados = merge(mayoresIzquierda, mayoresDerecha);
		Arrays.sort(combinados);

		// Devuelvo los primeros n elementos en orden descendente
		int[] resultado = new int[n];
		for (int i = 0; i < n; i++) {
			resultado[i] = combinados[combinados.length - 1 - i];
		}
		return resultado;
	}

	private static int[] merge(int[] lista1, int[] lista2) {
		int[] combinados = new int[lista1.length + lista2.length];
		System.arraycopy(lista1, 0, combinados, 0, lista1.length);
		System.arraycopy(lista2, 0, combinados, lista1.length, lista2.length);
		return combinados;
	}

	public static void main(String[] args) {
		int[] lista = {3, 5, 1, 9, 7, 8, 2, 6};
		int n = 3;
		int[] resultado = encontrarNMayores(lista, n);
		System.out.println("Los " + n + " elementos más grandes son: " + Arrays.toString(resultado));
	}
}
// Complejidad temporal : O ( n log n ) 

/*
La complejidad temporal es O(n log n). Esto se debe a que el algoritmo utiliza la función Arrays.sort() 
para ordenar los elementos combinados de las dos sublistas. La complejidad de Arrays.sort() es O(n log n), donde n es el tamaño de la lista combinada.
Además, el algoritmo realiza una operación de combinación de las dos sublistas utilizando la función merge(), 
que tiene una complejidad temporal de O(n), donde n es la suma de los tamaños de las dos sublistas.
En general, la complejidad temporal del algoritmo es dominada por la operación de ordenación, por lo que se considera O(n log n).
 */

 //Recurrencia: El algoritmo divide la lista en dos mitades, lo que nos lleva a una complejidad recursiva del tipo 
// T(m)=2T(m/2)+O(m), donde m es el tamaño de la lista.
