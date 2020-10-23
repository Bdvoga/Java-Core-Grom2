package lesson28.ex1;

import java.util.Comparator;
import java.util.Date;

public class FullComparator implements Comparator<Capability> {

    @Override
    public int compare(Capability o1, Capability o2) {
        //если channelName не равны - сравниваю по нему
        //если равно - перехожу к fingerprint
        //если fingerprint не равны - сравниваю по нему
        //если равно - перехожу к dateCreated
        //есле dateCreated не равны - сравниваю по нему
        //если равно - объекты равны

        if (check(o1.getChannelName(), o2.getChannelName()) != 0) {
            return check(o1.getChannelName(), o2.getChannelName());
        }

        if (check(o1.getFingerprint(), o2.getFingerprint()) != 0) {
            return check(o1.getFingerprint(), o2.getFingerprint());
        }

        if (check(o1.getDateCreated(), o2.getDateCreated()) != 0) {
            return check(o1.getDateCreated(), o2.getDateCreated());
        }

        return 0;
    }

    public <T extends Comparable<T>> int check(T t1, T t2) {
        if (t1 != null && t2 != null && !t1.equals(t2)) {
            return t1.compareTo(t2);
        }

        return 0;
    }
}