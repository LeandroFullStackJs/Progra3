package Clase3.act1;

import java.util.List;

public class Act1 {
    public static Cliente buscarMayorScoring(Cliente[] listaClientes) {
        return mayorScoring(listaClientes, listaClientes[0], listaClientes.length-1);
    }

    private static Cliente mayorScoring(Cliente[] listaClientes, Cliente clienteMayorScoring, int indice) {
        if (indice==0) {
            return clienteMayorScoring;
        }
        return mayorScoring(
                listaClientes,
                clienteMayorScoring.tengoMayorScoring(listaClientes[indice]) ? clienteMayorScoring : listaClientes[indice],
                indice-1);
    }
}
