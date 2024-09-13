package Clase3.act1.Act1V2;

class Cliente {
	int id;
	String nombre;
	int scoring;

	public Cliente(int id, String nombre, int scoring) {
		this.id = id;
		this.nombre = nombre;
		this.scoring = scoring;
	}

	public boolean tengoMayorScoring(Cliente otro) {
		return this.scoring >= otro.scoring;
	}
}

public class Act1V2 {
	public static Cliente buscarMayorScoring(Cliente[] listaClientes) {
		return buscarMayorScoringRec(listaClientes, 0, listaClientes.length - 1);
	}

	private static Cliente buscarMayorScoringRec(Cliente[] listaClientes, int inicio, int fin) {
		if (inicio == fin) {
			return listaClientes[inicio];
		}
		int medio = (inicio + fin) / 2;
		Cliente clienteIzquierda = buscarMayorScoringRec(listaClientes, inicio, medio);
		Cliente clienteDerecha = buscarMayorScoringRec(listaClientes, medio + 1, fin);
		if (clienteIzquierda.tengoMayorScoring(clienteDerecha)) {
            return clienteIzquierda;
        }  else 
            return clienteDerecha;
	}

	public static void main(String[] args) {
		Cliente[] listaClientes = {
			new Cliente(1, "Juan", 85),
			new Cliente(2, "Ana", 95),
			new Cliente(3, "Luis", 90),
			new Cliente(4, "Maria", 80)
		};
		Cliente clienteMayorScoring = buscarMayorScoring(listaClientes);
		System.out.println("Cliente con mayor scoring: " + clienteMayorScoring.nombre + " con scoring de " + clienteMayorScoring.scoring);
	}
}
/* Recurrencia: T(n) = 2T(n/2) + O(1)
Análisis Inductivo:
Para una lista de tamaño 1, la complejidad es O(1).
Para una lista de tamaño n, se divide en dos sublistas de tamaño n/2, y se realizan dos llamadas recursivas.
La comparación final toma O(1) tiempo.
Por lo tanto, la complejidad total es O(n log n) */