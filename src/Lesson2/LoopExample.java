package Lesson2;

public class LoopExample {
    public static void main(String[] args) {
        // for
        // while
        // for each (!) Пока не рассматриваем
        // do while

        //1. while loop
        int a = 1;

        while (a <= 10) {
            System.out.println(a);
            a++;
        }

        //2. do-while loop
        do {
            System.out.println(a);
            a++;
        } while (a <=10);
    }
}
