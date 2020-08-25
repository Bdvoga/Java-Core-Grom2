package lesson7;

import java.util.Date;

public class Demo {

    public static void main(String[] args) {
    }

    public Deal createOrder() {
        Deal deal = new Deal(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");

        return deal;
    }

    public Deal createOrderAndCallMethods() {
        Deal deal = new Deal(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");

        deal.confirmOrder();
        deal.isValidType();
        deal.checkPrice();

        return deal;
    }
}
