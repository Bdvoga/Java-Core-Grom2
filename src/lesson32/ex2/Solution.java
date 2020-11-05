package lesson32.ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void readNumbers() throws IOException {
        int n = 3;
        BufferedReader br;
        InputStreamReader reader;

        while (n > 0) {
            n--;
            reader = new InputStreamReader(System.in);
            br = new BufferedReader(reader);
            String[] str = br.readLine().split(" ");

            if (str.length != 10) {
                System.err.println("Your numbers are wrong. You have " + n + " attempts to try again");
                continue;
            }

            countSum(str, n);
        }

        System.out.println("Your numbers are wrong. Number of attempts exceeded");
    }

    private static void countSum(String[] str, int n) {
        int sum = 0;
        for (String el : str) {
            try {
                int i = new Integer(el);
                if (i > 100) {
                    System.err.println("Your numbers are wrong. You have " + n + " attempts to try again");
                    return;
                }
                sum += i;
            } catch (NumberFormatException e) {
                System.err.println("Int " + "Your numbers are wrong. You have " + n + " attempts to try again");
                return;
            }
        }

        System.out.println("Amount is " + sum);
        System.exit(0);
    }
}