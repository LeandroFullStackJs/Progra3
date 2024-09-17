package Clase6.act3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SeleccionOptimaProyectosPD {
    // Método principal
    public static void main(String[] args) {
        //parametros iniciales
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        // Mostrar el resultado
        System.out.println(
                "el beneficio maximo de un presupuesto de "
                        + presupuesto + " es: " + optimizarPresupuesto(costos, beneficios, presupuesto));
    }

    public static int optimizarPresupuesto(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (costos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + beneficios[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][presupuesto];
    }
}
