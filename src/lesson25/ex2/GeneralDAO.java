package lesson25.ex2;

public class GeneralDAO<T> {
    @SuppressWarnings("unchecked") // Аннотация для ИДЕ - ошибки в следующей строке нет (необязательна)
    private T[] array = (T[]) new Object[10]; // Создаем массив дженериков, приводим к типу T[]

    public T save(T t) throws Exception {
        if (t == null)
            throw new Exception("Can't save null object");

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null && t != null) {
                array[i] = t;
                return array[i];
            }
        }
        throw new Exception("There is not free space");
    }

    public T[] getAll() {
        return array;
    }

}
