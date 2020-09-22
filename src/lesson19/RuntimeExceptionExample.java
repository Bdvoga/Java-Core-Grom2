package lesson19;

public class RuntimeExceptionExample {
    public static void main(String[] args) {

        //arithmeticException
        arithmeticException(2);

        try {
            arithmeticException(0);
        } catch (ArithmeticException e) {
            System.out.println("something wrong");
        }

        npe(new Object());
        npe(null);

    }

    private static void arithmeticException(int a) {
        System.out.println(10 / a);
    }

    private static void npe(Object object) {
        //Так не делаем!!!!
//        try {
//            System.out.println(object.hashCode());
//        } catch (NullPointerException e) {
//            System.out.println();
//        }

        // Делаем так - через if
        if (object != null) {
            System.out.println(object.hashCode());
        }
    }
}
