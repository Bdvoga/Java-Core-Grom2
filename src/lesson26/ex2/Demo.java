package lesson26.ex2;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {

        ArrayList<Order> arr = ArrayListTest.useList();

        for (Order el : arr) {
            if (el != null) {
                System.out.println(el.getId() + ", " + el.getPrice() + ", " +
                        el.getCurrency() + ", " + el.getItemName() + ", " + el.getShopIdentificator());
            }
        }




    }



}
