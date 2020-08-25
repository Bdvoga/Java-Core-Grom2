package lesson8.ex1;

public class Arithmetic {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 17};
        System.out.println(check(array));

    }

    static boolean check(int[] array) {
        //ищем макс эл-т массива
        int max = array[0];
        for (int el : array) {
            if (el > max)
                max = el;
        }

        // мин эл-т массива
        int min = array[0];
        for (int el : array) {
            if (el < min)
                min = el;
        }

        return (max + min > 100);
    }

}
