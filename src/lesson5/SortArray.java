package lesson5;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] array = {1, 3, 2, 7, 5, 0};

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sortAscending(array)));
        System.out.println(Arrays.toString(sortDescending(array)));

    }

    //up
    static int[] sortAscending(int[] array) {
        int tmp;
        boolean needIteration = true;

        while (needIteration) {
            needIteration = false;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    needIteration = true;
                }
            }
        }

        return array;
    }

    //down
    static int[] sortDescending (int[] array) {
        int tmp;
        boolean needIteration = true;

        while (needIteration) {
            needIteration = false;

            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    needIteration = true;
                }
            }
        }

        return array;
    }

}
