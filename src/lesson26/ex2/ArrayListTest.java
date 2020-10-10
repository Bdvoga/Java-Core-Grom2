package lesson26.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {

    public static ArrayList<Order> useList() {
        Order order1 = new Order(1,100, "USD", "a", "A");
        Order order2 = new Order(2,200, "USD", "b", "A");
        Order order3 = new Order(3,300, "EUR", "c", "A");
        Order order4 = new Order(4,400, "GBP", "d", "A");
        Order order5 = new Order(5,400, "UAH", "d", "A");

        ArrayList<Order> arrayList = new ArrayList<>();
        ArrayList<Order> arrayList1 = new ArrayList<>();
        ArrayList<Order> arrayList2 = new ArrayList<>();

        arrayList.add(order1);
        arrayList.add(order2);

        arrayList.add(2, order3);

        arrayList.remove(1);

        arrayList.remove(order3);

        arrayList1.add(order4);
        arrayList1.add(order5);

        arrayList.addAll(arrayList1);

        List<Order> list = arrayList.subList(0, 2);
        //ArrayList<Order> list1 = arrayList.subList(0, 2);

        System.out.println(list.toString());

        arrayList.set(0, order5);

        if (arrayList.contains(order5)) {
            arrayList.remove(order5);
        }

        Object[] orders = arrayList1.toArray();

        System.out.println(orders.length);

        arrayList.addAll(arrayList1);
        arrayList.add(order1);

        arrayList1.clear();

        System.out.println();


        return arrayList;
    }
}
