package Lesson2;

public class BreakContinueExample {
    public static void main(String[] args) {
        int test = 10;

        // break
        while (test > 0) {
            System.out.println(test);
            System.out.println("...");
            test--;
            break;
        }

        // continue
        while (test > 0) {
            // можно реализовать continue через if
            System.out.println(test);
            System.out.println("...");
            test--;
        }
    }
}
