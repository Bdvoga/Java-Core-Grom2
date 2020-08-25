package lesson8.phonesexample;

public class IPhone extends Phone{
    int price; // fields
    double weight;
    String countryProduced;

    boolean fingerPrint;

    public IPhone(int price, double weight, String countryProduced, boolean fingerPrint) {
//        this.price = price;
//        this.weight = weight;
//        this.countryProduced = countryProduced;
        super(price, weight,countryProduced);
        this.fingerPrint = fingerPrint;

        System.out.println("IPhone constructor was invoked...");
    }

//    void orderPhone() { // methods // Будем брать из родительского класса Phone
//        //some logic - логика для этого примера не приципиальна, не пишем
//    }

    void deleteIPhoneFromDb() {
        System.out.println("deleteIPhoneFromDb invoked...");
    }
}
