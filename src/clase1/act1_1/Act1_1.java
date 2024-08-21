package clase1.act1_1;

import java.util.ArrayList;
import java.util.HashMap;

public class Act1_1 {

    //la compleijdad asintotica es O(n)
    public int parteA(int[] arr) {
        int nroMaximo = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || nroMaximo < arr[i]) {
                nroMaximo = arr[i];
            }
        }

        return nroMaximo;
    }

    //la compleijdad asintotica es O(m * n)
    public ArrayList<Act1_1ResultadoDTO> calcularImporteTotalPorClienteSinHashMap(ArrayList<ComprobanteFactura> listaDeComprobantes, ArrayList<Cliente> listaDeClientes) {
        ArrayList<Act1_1ResultadoDTO> listaIdClienteImporteTotal = new ArrayList<>();

        for (Cliente cliente : listaDeClientes) {
            double acc = 0;
            Long idCliente = cliente.getIdCliente();

           for (ComprobanteFactura comprobante : listaDeComprobantes) {
               if (idCliente == comprobante.getIdCliente()) {
                   acc += comprobante.getImporte();
               }
           }

           listaIdClienteImporteTotal.add(new Act1_1ResultadoDTO(idCliente, acc));
        }

        return listaIdClienteImporteTotal;
    }

    //la compleijdad asintotica es O(m + n)
    public ArrayList<Act1_1ResultadoDTO>  calcularImporteTotalPorClienteConHashMap(ArrayList<ComprobanteFactura> listaDeComprobantes, ArrayList<Cliente> listaDeClientes) {
        ArrayList<Act1_1ResultadoDTO> listaIdClienteImporteTotal;
        HashMap<Long, Double> hashMapIdClienteImporteTotal = new HashMap<>();

        for (Cliente cliente : listaDeClientes) {
            hashMapIdClienteImporteTotal.put(cliente.getIdCliente(), 0.0);
        }

        for (ComprobanteFactura comprobanteFactura : listaDeComprobantes) {
            Long idCliente = comprobanteFactura.getIdCliente();

            if (hashMapIdClienteImporteTotal.get(idCliente) != null) {

                hashMapIdClienteImporteTotal.put(
                        idCliente,
                        hashMapIdClienteImporteTotal.get(idCliente) + comprobanteFactura.getImporte()
                );
            }
        }

        listaIdClienteImporteTotal = new ArrayList<>();

        for (Long idCliente : hashMapIdClienteImporteTotal.keySet()) {
            listaIdClienteImporteTotal.add(new Act1_1ResultadoDTO(idCliente, hashMapIdClienteImporteTotal.get(idCliente)));
        }

        return listaIdClienteImporteTotal;
    }

}
