package Lesson2;

public class SumAndDivision {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 0; i <= 1000; i++) {
            sum += i;
        }

        int sum1 = sum / 1234;
        int sum2 = sum % 1234;

        System.out.println(sum2 > sum1);
    }
}
