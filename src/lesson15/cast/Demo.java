package lesson15.cast;

public class Demo {
    public static void main(String[] args) {
        InternetProvider provider = (InternetProvider) test(); //приведение тест к типу InternetProvider
        FoodProvider foodProvider = (FoodProvider) testFood();

        System.out.println(provider);
    }

    private static Provider test() { // возвращает тип Provider
        //some logic
        return new InternetProvider();
    }

    private static Provider testFood() {
        //some logic
        return new InternetProvider();
    }
}
