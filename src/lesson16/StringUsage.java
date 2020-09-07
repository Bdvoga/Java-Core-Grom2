package lesson16;

public class StringUsage {
    public static void main(String[] args) {
        String test = "someString";
        String result = test + "_end";
        System.out.println(result);

        char charVariable = 't'; //используем одинарные кавычки, тк двойные - строка
        char charVariable1 = 'o';
        char[] chars = {charVariable, charVariable1};

        String test1 = new String(chars); //конструктор в String - принимает массив и возвращает String
        System.out.println(test1);

        String test2 = new String("hello there");
        System.out.println(test2);
    }
}
