package lesson25.ex2;

import java.util.Arrays;

public class GeneralDAO<T> {
    @SuppressWarnings("unchecked") // Аннотация для ИДЕ - ошибки в следующей строке нет (необязательна)
    private T[] array = (T[]) new Object[10]; // Создаем массив дженериков, приводим к типу T[]

    public T save(T t) throws Exception {
        if (t == null) {
            throw new Exception("Can't save null object");
        }

        if (Arrays.asList(array).contains(t)) {
            throw new Exception("Object already exist");
        }

        int index = 0;
        for (T el : array) {
            if (el == null) {
                array[index] = t;
                return array[index];
            }
            index++;
        }

        throw new Exception("There is not free space");
    }

    public T[] getAll() {
        return array;
    }

}
