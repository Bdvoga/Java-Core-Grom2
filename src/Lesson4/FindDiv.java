package Lesson4;

public class FindDiv {
    public static void main(String[] args) {
        System.out.println(findDivCount(0, 10, 2));
    }

    public static int findDivCount(int a, int b, int n) {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (i % n == 0) {
                count++;
            }
        }

        return count;
    }

}
