package lesson28.ex1;

import java.util.*;

public class DemoComparator {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001, null, null, true, null);
        Capability capability2 = new Capability(1005, "test", "rrrr", false, new Date());
        Capability capability3 = new Capability(900, "test", "rrrr1", true, new Date());
        Capability capability4 = new Capability(800, "test2", "rrrr2", false, new Date());

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability4);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability1);

        Check<Capability> check = new Check<>();

        System.out.println(capabilities);

        //capabilities.sort(new isActiveComparator());

        System.out.println(capabilities);
        System.out.println();

        capabilities.sort(new DateComparator());
        System.out.println(capabilities);
        System.out.println();

        capabilities.sort(new FullComparator());
        System.out.println(capabilities);

//        // Переопределяем метод для примера 2.3
//        // Такая запись заменяет создание отдельного класса
//        Comparator<Capability> comparator = new Comparator<Capability>() {
//            @Override
//            public int compare(Capability o1, Capability o2) {
//
//                //если channelName не равны - сравниваю по нему
//                //если равно - перехожу к fingerprint
//                //если fingerprint не равны - сравниваю по нему
//                //если равно - перехожу к dateCreated
//                //есле dateCreated не равно - сравниваю по нему
//                //если равно - объекты равны
//
//                if (!o1.getChannelName().equals(o2.getChannelName()))
//                    return o1.getChannelName().compareTo(o2.getChannelName());
//
//                return 0;
//            }
//        };
    }
}
