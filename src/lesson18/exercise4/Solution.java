package lesson18.exercise4;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String text = "22 6 7 hjh 0";
        System.out.println(Arrays.toString(findNumbers(text)));
    }

    public static int[] findNumbers(String text) {
        String[] str = text.split(" ");
        int[] num = new int[str.length];
        int count = 0;

        for (String el : str) {
            boolean flag = true;
            char[] charEl = el.toCharArray();
            for (char ch : charEl) {
                if (!Character.isDigit(ch)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                num[count] = Integer.parseInt(el);
                count++;
            } else
                System.out.println("not a number");
        }

        int[] numbers = new int[count];
        int j = 0;
        for (int el : num) {
            if (el != 0) {
                numbers[j] = el;
                j++;
            }
        }

        return numbers;
    }
}
