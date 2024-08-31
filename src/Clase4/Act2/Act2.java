package Act2;

import java.util.Arrays;
import java.util.Collections;

public class Act2 {
	public static int minDocumentos(int cantidadObjetivo, Integer[] documentos) {
		// Ordenar los documentos en orden descendente
		Arrays.sort(documentos, Collections.reverseOrder());
		
		int cantidadRestante = cantidadObjetivo;
		int contador = 0;
		
		for (int documento : documentos) {
			while (cantidadRestante >= documento) {
				cantidadRestante -= documento;
				contador += 1;
			}
			if (cantidadRestante == 0) {
				break;
			}
		}
		
		if (cantidadRestante > 0) {
			return -1; // No es posible con los documentos dados
		}
		
		return contador;
	}

	public static void main(String[] args) {
		Integer[] documentos = {100, 50, 20, 10, 5, 1};
		int cantidadObjetivo = 93;
		int resultado = minDocumentos(cantidadObjetivo, documentos);
		
		if (resultado == -1) {
			System.out.println("No es posible con los documentos dados");
		} else {
			System.out.println("Número mínimo de documentos: " + resultado);
		}
	}
}

// Complejidad temporal : O ( n log n )



