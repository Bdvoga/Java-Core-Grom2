package Lesson4;

public class CompareSums {
    public static void main(String[] args) {

        System.out.println(compareSums(1, 5, 6, 9));
    }

    public static boolean compareSums(int a, int b, int c, int d) {
        if (sum(a, b) > sum(c, d)) {
            return true;
        } else {
            return false;
        }
    }

    public static int sum(int from, int to) {
        int sum = 0;
        for (int i = from; i <= to; i++) {
            sum += i;
        }

        return sum;
    }
}
