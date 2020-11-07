package lesson32.ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static int readNumbers() throws IOException {
        int n = 3;
        BufferedReader br;
        InputStreamReader reader;

        outerLoop: while (n > 0) {
            n--;
            reader = new InputStreamReader(System.in);
            br = new BufferedReader(reader);
            String[] str = br.readLine().split(" ");

            if (str.length != 10) {
                System.err.println("Your numbers are wrong. You have " + n + " attempts to try again");
                continue;
            }

            int sum = 0;
            for (String el : str) {
                if (validation(el, n)) {
                    sum += new Integer(el);
                } else {
                    continue outerLoop;
                }
            }

            return sum;
        }

        System.out.println("Your numbers are wrong. Number of attempts exceeded");
        return 0;
    }

    private static boolean validation(String str, int n) {
        try {
            int i = new Integer(str);
            if (i > 100) {
                System.err.println("Your numbers are wrong. You have " + n + " attempts to try again");
                return false;
            }
        } catch (NumberFormatException e) {
            System.err.println("Int " + "Your numbers are wrong. You have " + n + " attempts to try again");
            return false;
        }

        return true;
    }
}