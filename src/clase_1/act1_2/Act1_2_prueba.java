package clase_1.act1_2;

import java.math.BigInteger;

public class Act1_2_prueba {

    public static void main(String[] args) {
        Act1_2 longYBigInteger = new Act1_2(9223372036854775807L, new BigInteger("9223372036854775999"));
        System.out.println("valor de long: " + longYBigInteger.getNroLong());
        System.out.println("valor de BigInteger: " + longYBigInteger.getNroBigInteger().add(BigInteger.valueOf(1)));
    }

}
