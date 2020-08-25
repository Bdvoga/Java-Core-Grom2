package lesson6;

public class Demo {
    public static void main(String[] args) {
        // создаем объект, под него в памяти выделяются области
        // теперь можем работать с этими областями,
        Car carObject = new Car(10000, 2015, "Anton");

        // Вызываем методы классов User, Car, DbConnector через их объекты

        System.out.println(carObject.color);
        System.out.println(carObject.horsePower);

        System.out.println(carObject.ownerName);

        carObject.horsePower = 100;

        System.out.println(carObject.horsePower);

        // в объкте можем вызывать методы
        carObject.startRun();
        carObject.stopRun();

        carObject.changeOwner("Test");

        System.out.println(carObject.ownerName);

    }
}
