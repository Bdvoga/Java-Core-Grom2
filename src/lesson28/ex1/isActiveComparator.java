package lesson28.ex1;

import java.util.Comparator;

public class isActiveComparator implements Comparator<Capability> {

    @Override
    public int compare(Capability o1, Capability o2) {
        System.out.println("isActiveComparator is used");

        if (o1.isActive() && !o2.isActive()) {
            return -1; // ничего не делаем, 1-й объект активен, второй нет
        }
        else if ((o1.isActive() && o2.isActive()) || (!o1.isActive() && !o2.isActive()))
            return 0; // ничего не делаем
        else
            return 1; // меняем местами

    }
}