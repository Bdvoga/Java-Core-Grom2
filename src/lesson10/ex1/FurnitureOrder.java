package lesson10.ex1;

import java.util.Date;

public class FurnitureOrder extends Order {
    String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity,
                          String shipToCity, int basePrice, Customer customerOwned,
                          String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        if ((getShipFromCity() == "Kyiv" || getShipFromCity() == "Lviv") &&
                (getBasePrice() < 500) &&
                (getCustomerOwned().getName() == "Test")) {
            confirmShipping();
        }
    }

    @Override
    public void calculatedPrice() {
        double priceWithDelivery = getBasePrice() < 5000 ?
                getBasePrice() * 1.05 : getBasePrice() * 1.02;

        setTotalPrice(priceWithDelivery);
    }
}
