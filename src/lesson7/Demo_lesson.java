package lesson7;

import lesson6.Car;
import lesson6.DbConnector;
import lesson6.User;

public class Demo_lesson {
    public static void main(String[] args) {
        // two options to create object
        // (class name(type)) (object name) = (new) (class name());
        // (class name(type)) (object name) = (new) (class name(attributes));

        // Создаем объект: user, user1, user2 - 3 разных объкта с пустым конструктором из Урока 6
        User user = new User();
        User user1 = new User();
        User user2 = new User();

        User user3 = new User("Jack"); //Констурктор берем из lesson6
        // user - user2 и user3 созданы с помощью разных конструкторов, но из одного класса User

        // Еще один объект класса Car
        Car newCar = new Car(10000, 2015, "Anton");


        // Еще один - класс dbConnector
        DbConnector dbConnector = new DbConnector();

        System.out.println(newCar.price);

    }
}
