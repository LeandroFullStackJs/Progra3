package clase1.act1_1;

import java.util.ArrayList;

public class Act1_1_prueba {
    public static void main(String[] args) {

        Act1_1 act1 = new Act1_1();

        System.out.println("actividad1.1 ej A: " + act1.parteA(new int[]{1,99,2,3}));

        //obj para el eje B
        ArrayList<Cliente> listaDeClientes = new ArrayList<>();
        ArrayList<ComprobanteFactura> listaDeComprobantesDeFacturas = new ArrayList<>();

        //instancio los obj
        Cliente cliente1 = new Cliente(1L, "enzo");
        Cliente cliente2 = new Cliente(2L, "julian");
        ComprobanteFactura factura1 = new ComprobanteFactura(1L, 1L, 100.0);
        ComprobanteFactura factura2 = new ComprobanteFactura(2L, 1L, 50.0);
        ComprobanteFactura factura3 = new ComprobanteFactura(3L, 2L, 75.0);
        ComprobanteFactura factura4 = new ComprobanteFactura(4L, 3L, 1000.0);

        //agrego los obj a sus listas
        listaDeClientes.add(cliente1);
        listaDeClientes.add(cliente2);
        listaDeComprobantesDeFacturas.add(factura1);
        listaDeComprobantesDeFacturas.add(factura2);
        listaDeComprobantesDeFacturas.add(factura3);
        listaDeComprobantesDeFacturas.add(factura4);

        long inicio = System.nanoTime();
        System.out.println(act1.calcularImporteTotalPorClienteSinHashMap(listaDeComprobantesDeFacturas, listaDeClientes));
        long fin = System.nanoTime();
        System.out.println("tiempo que tarda sin #map: " + (fin-inicio));

        inicio = System.nanoTime();
        System.out.println(act1.calcularImporteTotalPorClienteConHashMap(listaDeComprobantesDeFacturas, listaDeClientes));
        fin = System.nanoTime();
        System.out.println("tiempo que tarda con #map: " + (fin-inicio));

    }
}
