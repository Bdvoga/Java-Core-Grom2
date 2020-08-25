package lesson8.phonesexample;

public class Phone {
    int price; // fields
    double weight;
    String countryProduced;

    public Phone(int price, double weight, String countryProduced) { // Constructor
        System.out.println("Phone constructor was invoked...");
        this.price = price;
        this.weight = weight;
        this.countryProduced = countryProduced;
    }

    void orderPhone() { // method
        System.out.println("order phone invoked...");
    }
}
