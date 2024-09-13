import java.util.Arrays;

class CambioMonedas {

    public static boolean puedeDarCambioExacto(int[] monedas, int monto) {
        // Ordenar las monedas en orden descendente
        Arrays.sort(monedas);
        
        // Recorrer desde la moneda de mayor valor hacia la de menor valor
        for (int i = monedas.length - 1; i >= 0; i--) {
            while (monto >= monedas[i]) {
                monto -= monedas[i];
            }
        }
        
        // Si el monto es exactamente 0, entonces es posible dar el cambio
        return monto == 0;
    }

    public static void main(String[] args) {
        int[] monedas = {1, 5, 10, 25};
        int monto = 36;

        boolean resultado = puedeDarCambioExacto(monedas, monto);
        if (resultado) {
            System.out.println("Es posible dar el cambio exacto para " + monto + ".");
        } else {
            System.out.println("No es posible dar el cambio exacto para " + monto + ".");
        }
    }
} // Complejidad temporal : O ( n log n ) 
