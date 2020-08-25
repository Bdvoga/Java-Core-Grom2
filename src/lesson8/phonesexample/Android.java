package lesson8.phonesexample;

public class Android extends Phone {
    String androidVersion;
    int screenSize;

    String secretDeviceCode;

    //constructor
    public Android(int price, double weight, String countryProduced, String androidVersion, int screenSize, String secretDeviceCode) {
//        this.price = price;
//        this.weight = weight;
//        this.countryProduced = countryProduced; // заменили 3 строки на super
        super(price, weight, countryProduced);

        // this - reference to the current class
        // super - reference to the parent class, работает только при наличии extends Phone {

        this.androidVersion = androidVersion;
        this.screenSize = screenSize;
        this.secretDeviceCode = secretDeviceCode;
    }

//    void orderPhone() { // method // Будем брать из родительского класса Phone
//        //some logic
//    }

    void installNewAndroidVersion() {
        System.out.println("installNewAndroidVersion invoked...");
    }

}
