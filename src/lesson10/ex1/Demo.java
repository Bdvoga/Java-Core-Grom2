package lesson10.ex1;

import java.util.Date;

public class Demo {

    public static void main(String[] args) {
        Customer customer1 = new Customer("Diana", "Kyiv", "F");
        Customer customer2 = new Customer("Tom", "Lviv", "M");

        ElectronicsOrder[] electronicsOrders = new ElectronicsOrder[2];
        electronicsOrders[0] = new ElectronicsOrder("iPhone",
                new Date(), "Kyiv", "Kyiv",
                999, customer1, 10);
        electronicsOrders[1] = new ElectronicsOrder("Nexus",
                new Date(), "Dnepr", "Kyiv", 50,
                customer2, 6);

        for (ElectronicsOrder el : electronicsOrders) {
            el.validateOrder();
            el.calculatedPrice();
        }

        FurnitureOrder[] furnitureOrders = new FurnitureOrder[2];
        furnitureOrders[0] = new FurnitureOrder("Table", new Date(),
                "Kyiv", "Rivne", 600, customer1,
                "abc");
        furnitureOrders[1] = new FurnitureOrder("Bed", new Date(), "Dnepr",
                 "Odesa", 7000, customer2, "def");

        for (FurnitureOrder el : furnitureOrders) {
            el.validateOrder();
            el.calculatedPrice();
        }
    }
}
