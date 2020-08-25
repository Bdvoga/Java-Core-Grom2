package Lesson1;

import lesson9.utils.Checker;

public class FirstProgram {
    public static void main(String[] args) {
        System.out.println("My first Java program...");
        System.out.println("Done");

        Checker checker = new Checker();
        System.out.println(checker.checkCompanyName("Google"));

    }
}
