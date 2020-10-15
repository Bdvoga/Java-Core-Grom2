package lesson29.ex1;

import lesson29.fromLesson.File;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        useHashSet();
    }

    static void useHashSet() {

        Set<Order> orders = new HashSet<>();
        Order order1 = new Order(1, 100, "USD", "a", "A");
        Order order2 = new Order(2, 200, "EUR", "b", "B");
        Order order3 = new Order(3, 300, "UAH", "c", "C");
        Order order4 = new Order(4, 400, "YEN", "d", "D");
        Order order5 = new Order(5, 400, "YEN", "d", "D");
        Order order6 = new Order(6, 400, "YEN", "d", "D");
        Order order7 = new Order(7, 400, "YEN", "d", "D");

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        System.out.println(orders);
        System.out.println();

        orders.remove(order1);
        System.out.println(orders);

        Set<Order> orders1 = new HashSet<>();
        orders1.add(order1);
        orders1.add(order2);

        orders.retainAll(orders1);
        System.out.println(orders);
        System.out.println();

        Object[] arr = orders.toArray();
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(orders.toArray()));
        System.out.println();

        System.out.println(orders.size());
        System.out.println();

        orders.add(order4);
        orders.add(order5);
        orders.add(order6);
        orders.add(order7);
        orders.add(order7);

        Iterator<Order> orderIterator = orders.iterator();
        while (orderIterator.hasNext()) {
            System.out.println(orderIterator.next().getId());
        }
    }
}
