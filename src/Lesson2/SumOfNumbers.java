package Lesson2;

public class SumOfNumbers {
    public static void main(String[] args) { // sum from 0 to 10 bil
        long sum = 0;
        int i = 0;

        while (i <= 10000000) {
            sum += i;
            i++;
        }

        System.out.println(sum);

        sum = 0;

        for (i = 0; i <= 10000000; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}
