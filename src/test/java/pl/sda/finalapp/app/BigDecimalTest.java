package pl.sda.finalapp.app;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BigDecimalTest {
    @Test
    void tester() {
        double a = 0.02;
        double b = 0.03;
        System.out.println(a - b);

        BigDecimal bigDecimal = new BigDecimal(0.02);
        BigDecimal bigDecimal2 = new BigDecimal(0.03);
        System.out.println(bigDecimal.subtract(bigDecimal2));

        BigDecimal bigDecimal3 = new BigDecimal("0.02");
        BigDecimal bigDecimal4 = new BigDecimal("0.03");
        System.out.println(bigDecimal3.subtract(bigDecimal4));

        BigDecimal bigDecimal5 = BigDecimal.valueOf(0.02);
        BigDecimal bigDecimal6 = BigDecimal.valueOf(0.03);
        System.out.println(bigDecimal5.subtract(bigDecimal6));
    }
}
