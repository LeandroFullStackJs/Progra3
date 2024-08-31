package Clase3.Act3;

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

public class Act3 {
    public static class Result {
        Cliente mayor;
        Cliente segundoMayor;

        public Result(Cliente mayor, Cliente segundoMayor) {
            this.mayor = mayor;
            this.segundoMayor = segundoMayor;
        }
    }

    public static Result encontrarDosMayoresClientes(Cliente[] listaClientes) {
        if (listaClientes.length < 2) {
            throw new IllegalArgumentException("La lista debe contener al menos dos clientes");
        }
        return encontrarDosMayoresClientesRec(listaClientes, 0, listaClientes.length - 1);
    }

    private static Result encontrarDosMayoresClientesRec(Cliente[] listaClientes, int inicio, int fin) {
        if (inicio == fin) {
            throw new IllegalArgumentException("No hay un segundo mayor cliente");
        }
        if (fin - inicio == 1) {
            Cliente mayor = listaClientes[inicio].tengoMayorScoring(listaClientes[fin]) ? listaClientes[inicio] : listaClientes[fin];
            Cliente segundoMayor = listaClientes[inicio].tengoMayorScoring(listaClientes[fin]) ? listaClientes[fin] : listaClientes[inicio];
            return new Result(mayor, segundoMayor);
        }

        int medio = (inicio + fin) / 2;
        Result izquierda = encontrarDosMayoresClientesRec(listaClientes, inicio, medio);
        Result derecha = encontrarDosMayoresClientesRec(listaClientes, medio + 1, fin);

        Cliente mayor, segundoMayor;
        if (izquierda.mayor.tengoMayorScoring(derecha.mayor)) {
            mayor = izquierda.mayor;
            segundoMayor = izquierda.segundoMayor.tengoMayorScoring(derecha.mayor) ? izquierda.segundoMayor : derecha.mayor;
        } else {
            mayor = derecha.mayor;
            segundoMayor = derecha.segundoMayor.tengoMayorScoring(izquierda.mayor) ? derecha.segundoMayor : izquierda.mayor;
        }

        return new Result(mayor, segundoMayor);
    }

    public static void main(String[] args) {
        Cliente[] listaClientes = {
            new Cliente(1, "Juan", 85),
            new Cliente(2, "Ana", 95),
            new Cliente(3, "Luis", 90),
            new Cliente(4, "Maria", 80)
        };
        try {
            Result resultado = encontrarDosMayoresClientes(listaClientes);
            System.out.println("Cliente con mayor scoring: " + resultado.mayor.nombre + " con scoring de " + resultado.mayor.scoring);
            System.out.println("Cliente con segundo mayor scoring: " + resultado.segundoMayor.nombre + " con scoring de " + resultado.segundoMayor.scoring);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Complejidad temporal : O ( n log n )

/*Caso Base:

Si la lista tiene menos de dos clientes, se lanza una excepción, lo cual es O(1).
Paso Recursivo:

Dividimos la lista en dos sublistas de tamaño n/2.
Realizamos dos llamadas recursivas para encontrar los dos clientes con los scoring máximos en cada sublista.
Comparamos los resultados de las dos sublistas, lo cual toma O(1) tiempo.
Complejidad Total:

La recurrencia es T(n) = 2T(n/2) + O(1).
Por inducción, podemos ver que la complejidad total es O(n log n). */