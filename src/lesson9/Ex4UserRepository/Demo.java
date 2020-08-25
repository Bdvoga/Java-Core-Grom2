package lesson9.Ex4UserRepository;

import java.util.Arrays;

public class Demo {
    // 2.1. Создаем массивы пользователей
    static User user0 = new User(1, "Mike", "111");
    static User user1 = new User(2, "Dock", "222");
    static User user2 = new User(3, "Tom", "333");
    static User user3 = null;
    static User user4 = new User(4, "Frida", "777");

    // 2.2. Объединяем массивы пользователей в новый массив
    static User[] users = {user0, user1, user2, user3,};

    // 2.3. Создаем объект из массивов
    static UserRepository userRepository = new UserRepository(users);

     //2.4. Класс мэйн для проверки
    public static void main(String[] args) {
        System.out.println(findById(user4.getId()));
        System.out.println(save(user4));

}

   // 3.2 Есть ли такой юзер (проверяем по id)
    public static User findById(long id) {
        for (User el : userRepository.getUsers()) {
            if (el == null) {
                return null;
            }
            if (el.getId() == id)
                return el;

        }
        return null;
    }

    // part 4.
    public static User save(User user) {
        if (findById(user.getId()) != null) {
            return null;
        }

        for (int i = 0; i < userRepository.getUsers().length; i++) {
            if (userRepository.getUsers()[i] == null) {
                userRepository.getUsers()[i] = user;

                return userRepository.getUsers()[i];
            }
        }

        return null;
    }

    // Печатаем массив юзеров
    public static void printUsers() {
        for (User el : userRepository.getUsers()) {
            System.out.println(el.getId());
            System.out.println(el.getName());
            System.out.println(el.getSessionId());
            System.out.println("--------");
        }
    }

}
