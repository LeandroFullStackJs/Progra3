package actividad1.act1_1;

public class Cliente {

    private Long idCliente;
    private String nombre;

    public Cliente(Long idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }

    public Long getIdCliente() {
        return idCliente;
    }
}
