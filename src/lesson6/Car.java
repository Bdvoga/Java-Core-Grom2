package lesson6;

public class Car {

    //1 filds - поля или свойства
    public int price;
    int yearOfManufacturing;
    String color;
    String ownerName;
    double weight;
    int horsePower;

    //2 costructor - определяет, каким образом будет создаваться этот объект
    // горячие клавиши для создания Alt + Insert
    // в конструкторе есть только тип возращаемого объекта, названия нет

    // конструкторов может быть бесконечное кол-во (на практие дб <= 3)
    // или не быть совсем

    public Car(int price, int yearOfManufacturing, String ownerName) {
        this.price = price;
        this.yearOfManufacturing = yearOfManufacturing;
        this.ownerName = ownerName;

        // this. - указывает на текущий класс, в котором используем это ключевое слово
    }

    //3 methods - подробно описываем поведение классов (задаем поведение)
    // (методом мы описываем как конкретный класс может себя вести в рамках даного прокта)
    void startRun() {
        System.out.println("I am running...."); // может ездить
    }

    void stopRun() {
        System.out.println("I am stopping..."); // может останавливаться
    }

    void changeOwner(String newOwnerNames) { // может изменить владельца
        ownerName = newOwnerNames;
    }

    //4 inner class - в классе мб другие классы (рассмотрим позже)
//    private class Test {
//
//    }

}
