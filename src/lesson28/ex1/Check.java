package lesson28.ex1;

import java.util.Comparator;

public class Check<T extends Comparable<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {

        if (o1 != null && o2 != null && !o1.equals(o2)) {
            return o1.compareTo(o2);
        }

        return 0;
    }
}