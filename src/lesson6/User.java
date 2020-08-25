package lesson6;

import java.util.Date;

public class User { // Создаем класс для храниения данных о пользователе
    String name;
    int age;
    String city;
    Date lastActiveDate; // новый тип данных - дата
    boolean isActive;

    //3. Можно создать пустой конструктор 3
    public User() {
    }

    // Создаем конструктор 1
    public User(String name, int age, String city, Date lastActiveDate, boolean isActive) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.lastActiveDate = lastActiveDate;
        this.isActive = isActive;
    }

    //2. Создадим еще один конструктор 2
    public User(String name) {
        this.name = name;
    }

    //1. создаем новый метод, кот присваивает текущую дату
    void logIn() {
        lastActiveDate = new Date();
    }

    void isActive(boolean status) { // активен или нет, может поменять статус
        isActive = status;
    }

    void icreaseAge() { // метод на увеличение возраста
        age++;
    }
}
