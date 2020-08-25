package lesson12;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(Currency.USD);

        System.out.println(Arrays.toString(Currency.values()));

        String usd = "USD";

        Currency udsConverted = Currency.valueOf(usd);

        System.out.println(udsConverted);

        System.out.println(Currency.values());
    }
}
