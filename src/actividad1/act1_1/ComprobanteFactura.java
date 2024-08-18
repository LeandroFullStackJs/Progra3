package actividad1.act1_1;

public class ComprobanteFactura {

    private Long idFactura;
    private Long idCliente;
    private double importe;

    public ComprobanteFactura(Long idFactura, Long idCliente, double importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public double getImporte() {
        return importe;
    }
}
