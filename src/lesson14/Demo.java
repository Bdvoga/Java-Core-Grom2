package lesson14;

public class Demo {
    public static void main(String[] args) {

        Object objectTest = new Object();

        System.out.println(objectTest.toString()); // Что бы посмотреть описание метода: мышь на метод +
                                                //<Ctrl> + <левая кн мыши>
        System.out.println(objectTest.getClass().getName());

        objectTest = new Object();

        System.out.println(objectTest.toString());
        System.out.println(objectTest.getClass().getName());

        objectTest = new Object();

        System.out.println(objectTest.toString());
        System.out.println(objectTest.getClass().getName());
    }
}
