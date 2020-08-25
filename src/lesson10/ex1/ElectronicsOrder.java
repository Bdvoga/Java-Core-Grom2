package lesson10.ex1;

import java.util.Date;

public class ElectronicsOrder extends Order{
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity,
                            String shipToCity, int basePrice, Customer customerOwned,
                            int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {
        if ((getShipFromCity() == "Kyiv" || getShipFromCity() == "Dnepr" ||
                getShipFromCity() == "Odesa" || getShipFromCity() == "Kharkiv") &&
                (getShipToCity() == "Kyiv" || getShipToCity() == "Dnepr" ||
                getShipToCity() == "Odesa" || getShipToCity() == "Kharkiv") &&
                (getCustomerOwned().getGender() == "F")) {
            confirmShipping();
        }
    }

    @Override
    public void calculatedPrice() {
        double priceWithDelivery = getShipToCity() == "Kyiv" || getShipToCity() == "Odesa" ?
                getBasePrice() * 1.1 : getBasePrice() *1.15;

        if (getBasePrice() > 1000)
            priceWithDelivery = priceWithDelivery * 0.95;

        setTotalPrice(priceWithDelivery);
    }

}
