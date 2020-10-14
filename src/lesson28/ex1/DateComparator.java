package lesson28.ex1;

import java.util.Comparator;

public class DateComparator implements Comparator<Capability> {

    @Override
    public int compare(Capability o1, Capability o2) {

        return o1.getDateCreated().compareTo(o2.getDateCreated());

//        if (o1.getDateCreated().getTime() < o2.getDateCreated().getTime()) {
//            return -1;
//        } else if (o1.getDateCreated().getTime() == o2.getDateCreated().getTime()) {
//            return 0;
//        } else {
//            return 1;
//        }
    }
}
