package lesson18.exercise3;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        String text = "22 6 ggg 7 6.7 0";
        System.out.println(Arrays.toString(findNumber(text)));

    }

    public static int[] findNumber(String text) {
        String[] words = text.split(" ");
        int[] numbers = new int[words.length];
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            try {
                numbers[i] = Integer.parseInt(words[i]);
                count++;
            } catch (Exception e) {
                System.out.println("not a number");
            }
        }

        int[] numbersInt = new int[count];
        int j = 0;
        for (int el : numbers) {
            if (el != 0) {
                numbersInt[j] = el;
                j++;
            }
        }
        return numbersInt;
    }
}