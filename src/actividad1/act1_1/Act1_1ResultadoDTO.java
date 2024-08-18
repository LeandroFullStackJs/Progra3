package actividad1.act1_1;

public class Act1_1ResultadoDTO {

    private Long idCliente;
    private double importe;

    public Act1_1ResultadoDTO(Long idCliente, double importe) {
        this.idCliente = idCliente;
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Act1_1ResultadoDTO{" +
                "idCliente=" + idCliente +
                ", importe=" + importe +
                '}';
    }
}
