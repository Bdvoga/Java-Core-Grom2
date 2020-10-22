package lesson28.ex1;

import java.util.Comparator;

public class Check<T> implements Comparator<T> {

    @Override
    public int compare(T t1, T t2) {
        if (t1 != null && t2 != null && !t1.equals(t2)) {
            return t1.compareTo(t2);
        }


        return 0;
    }

}