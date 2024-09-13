package Act3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

class Mercancia {
	double peso;
	double valor;
	double valorPorPeso;

	public Mercancia(double peso, double valor) {
		this.peso = peso;
		this.valor = valor;
		this.valorPorPeso = valor / peso;
	}
}

public class Act3 {
	public static List<Mercancia> cargarCamion(double capacidadMaxima, Mercancia[] mercancias) {
		// Ordenar las mercancías por valor por unidad de peso en orden descendente
		Arrays.sort(mercancias, Comparator.comparingDouble(m -> -m.valorPorPeso));
		
		double capacidadRestante = capacidadMaxima;
		double valorTotal = 0.0;
		List<Mercancia> listaCargada = new ArrayList<>();

		System.out.println("Elementos a cargar en el camión:");

		for (Mercancia mercancia : mercancias) {
			if (capacidadRestante == 0) {
				break;
			}
			if (mercancia.peso <= capacidadRestante) {
				System.out.println("Cargar: " + mercancia.peso + " kg, Valor: " + mercancia.valor);
				capacidadRestante -= mercancia.peso;
				valorTotal += mercancia.valor;
				listaCargada.add(mercancia);
			} else {
				double fraccion = capacidadRestante / mercancia.peso;
				System.out.println("Cargar: " + (mercancia.peso * fraccion) + " kg, Valor: " + (mercancia.valor * fraccion));
				valorTotal += mercancia.valor * fraccion;
				listaCargada.add(new Mercancia(mercancia.peso * fraccion, mercancia.valor * fraccion));
				capacidadRestante = 0;
			}
		}

		System.out.println("Valor total cargado: " + valorTotal);
		return listaCargada;
	}

	public static void main(String[] args) {
		Mercancia[] mercancias = {
			new Mercancia(10, 60),
			new Mercancia(20, 100),
			new Mercancia(30, 120)
		};
		double capacidadMaxima = 50;
		List<Mercancia> resultado = cargarCamion(capacidadMaxima, mercancias);
		
		System.out.println("Lista de mercancías cargadas:");
		for (Mercancia mercancia : resultado) {
			System.out.println("Peso: " + mercancia.peso + " kg, Valor: " + mercancia.valor);
		}
	}
}


// Complejidad temporal : O ( n log n )
