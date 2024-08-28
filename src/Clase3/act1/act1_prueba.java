package Clase3.act1;

public class act1_prueba {

    public static void main(String []args){
        Cliente[] listaClientes = new Cliente[]{
                new Cliente(1,"Juan",1.9),
                new Cliente(2,"enzo",3.0),
                new Cliente(3,"Pedro",1.4),
                new Cliente(4,"Raul",1.5),
                new Cliente(5,"Maria",3.1)
        };
        System.out.println(Act1.buscarMayorScoring(listaClientes).toString());
    }

}
