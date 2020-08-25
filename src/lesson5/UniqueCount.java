package lesson5;

public class UniqueCount {
    public static void main(String[] args) {
        int[] array = {11, 12, 10, 5, 4, 44, 100, 44, 11, 10, 11};
        System.out.println(uniqueCount(array));

    }

    public static int uniqueCount(int[] array) {
        //1. Внешний цикл считает уникальные с повторамb
        //2. Внутренний цикл считает повторы
        //3. Разница = уникам без повторов

        int countTotal = 0;
        int countRepeat = 0;
        for (int i = 0; i < array.length; i++) {
            countTotal++;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    countRepeat++;
                    break;
                }
            }
        }

        return countTotal - countRepeat;
    }

}
