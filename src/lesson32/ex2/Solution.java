package lesson32.ex2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static int readNumbers() throws IOException {
        int n = 3;
        int count, sum;
        while (n > 0) {
            n--;
            InputStreamReader reader = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(reader);
            String[] str = br.readLine().split(" ");

            if (str.length != 10) {
                System.out.println("Your numbers are wrong. You have " + n + " attempts to try again");
                continue;
            }

            sum = 0;
            count = 0;
            for (String el : str) {
                try {
                    int i = new Integer(el);
                    if (i > 100) {
                        System.out.println("Your numbers are wrong. You have " + n + " attempts to try again");
                        break;
                    }
                    count++;
                    sum += i;
                } catch (NumberFormatException e) {
                    System.out.println("Your numbers are wrong. You have " + n + " attempts to try again");
                    break;
                }
            }

            if (count == 10) {
                System.out.println("Amount is " + sum);
                return sum;
            }
        }

        System.out.println("Your numbers are wrong. Number of attempts exceeded");
        return 0;
    }
}