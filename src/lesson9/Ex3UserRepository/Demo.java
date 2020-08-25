package lesson9.Ex3UserRepository;

import java.util.Arrays;

public class Demo {
    // 2.1. Создаем массивы пользователей
    public static User user = new User(12345, "Mike", "111");
    public static User user1 = new User(1232, "Dock", "222");
    public static User user2 = new User(2134, "Tom", "333");

    // 2.2. Объединяем массивы пользователей в новый массив
    public static User[] users = {user, user1, user2};

    // 2.3. Создаем объект из массивов
    public static UserRepository userRepository = new UserRepository(users);

    // 2.4. Класс мэйн для проверки
    public static void main(String[] args) {
        // part 3
        System.out.println(getUserByName("Tom").getName());
        System.out.println(getUserById(1232).getId());
        System.out.println(getUserBySessionId("1111"));
    }

    // 3.1. User Repository, part 3
    public static User getUserByName(String name) {
        //for (int i = 0; i < userRepository.getUsers().length; i++) {
        for (User el : users) {
            if (el.getName() == name)
                return el;
            }
        return null;
    }

    // 3.2
    public static User getUserById(long id) {
        for (User el : users)    {
            if (el.getId() == id)
                return el;
        }
        return null;
    }

    // 3.3
    public static User getUserBySessionId(String session) {
        //for (int i = 0; i < userRepository.getUsers().length; i++) {
        for (User el: users) {
            if (el.getSessionId() == session)
                return el;
        }
        return null;
    }
}
