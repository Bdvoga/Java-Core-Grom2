package lesson9.Ex2SearchUser;

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
        // part 2
        System.out.println(Arrays.toString(getUserNames()));
        System.out.println(Arrays.toString(getUserIds()));
        System.out.println(getUserNameById(1232));
    }

    // 2.5. Метод для получения массива имен
    public static String[] getUserNames() {
        String[] arrayName = new String[userRepository.getUsers().length]; // Создаем массив для имен пользователей

        // заполняем массив id пользователей
        for (int i = 0; i < userRepository.getUsers().length; i++) {
            arrayName[i] = userRepository.getUsers()[i].getName();
        }

        return arrayName;
    }

    // 2.6. Метод для получения массива id
    public static long[] getUserIds() {
        long[] arrayId = new long[userRepository.getUsers().length]; // Создаем массив для имен пользователей

        // заполняем массив id пользователей
        for (int i = 0; i < userRepository.getUsers().length; i++) {
            arrayId[i] = userRepository.getUsers()[i].getId();
        }

        return arrayId;
    }

    // 2.7. Метода для получ. имени по ид
    public static String getUserNameById(long id) {
        String str = "";
        for (int i = 0; i < userRepository.getUsers().length; i++) {
            if (userRepository.getUsers()[i].getId() == id)
                str = userRepository.getUsers()[i].getName();
        }
        return str;
    }

}
