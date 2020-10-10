package lesson27.ex2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LInkedListTest {

    public static LinkedList<Order> useList() {
        Order order1 = new Order(1, 100, "USD", "a", "A");
        Order order2 = new Order(2, 200, "USD", "b", "A");
        Order order3 = new Order(3, 300, "EUR", "c", "A");
        Order order4 = new Order(4, 400, "GBP", "d", "A");
        Order order5 = new Order(5, 400, "UAH", "d", "A");

        LinkedList<Order> linkedList = new LinkedList<>();
        LinkedList<Order> linkedList1 = new LinkedList<>();
        LinkedList<Order> linkedList2 = new LinkedList<>();

        linkedList.add(order1);
        linkedList.add(order2);

        linkedList.add(2, order3);

        linkedList.remove(1);

        linkedList.remove(order3);

        linkedList1.add(order4);
        linkedList1.add(order5);

        linkedList.addAll(linkedList1);

        List<Order> list = linkedList.subList(0, 2);
        //ArrayList<Order> list1 = arrayList.subList(0, 2);

        System.out.println(list.toString());

        linkedList.set(0, order5);

        if (linkedList.contains(order5)) {
            linkedList.remove(order5);
        }

        Object[] orders = linkedList1.toArray();

        System.out.println(orders.length);
        System.out.println(orders[0].toString());

        linkedList.addAll(linkedList1);
        linkedList.add(order1);

        linkedList1.clear();

        System.out.println();


        return linkedList;
    }
}
