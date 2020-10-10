package lesson27.ex2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Demo {

    public static void main(String[] args) {

        LinkedList<Order> arr = LInkedListTest.useList();

        for (Order el : arr) {
            if (el != null) {
                System.out.println(el.getId() + ", " + el.getPrice() + ", " +
                        el.getCurrency() + ", " + el.getItemName() + ", " + el.getShopIdentificator());
            }
        }

        System.out.println(arr.toString());
    }
}
