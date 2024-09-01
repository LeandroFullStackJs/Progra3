package clase1.act1_3;

public final class SumaDeEnterosRecursivo {
    public static int sumarEnterosRecursivamente(int nro) {
        if (nro == 0) {
            return nro;
        }
        return sumarEnterosRecursivamente(nro-1) + nro;
    }
}