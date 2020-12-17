package lesson13;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        User user = new User(1001, "Ann", "jfh67d");
        userRepository.save(user);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        userRepository.save(user);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        // Что нужно проверять
        // Работа метода save() - сохранять юзера
        // Сохранять того же юзера
        // нет места в массве
        // сохраняем null

        int n = 15;
        while (n > 0) {
            User user1 = new User(n, "Ann", "jfh67d");
            System.out.println(userRepository.save(user1));
            n--;
        }

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        userRepository.save(null);

        //test update
        user = new User(1001, "Ann", "111");
        userRepository.update(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //обновление юзера
        //когда нет юзера на обновление
        //когда обновляем null

        user = new User(999, "Ann", "111");
        userRepository.update(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        System.out.println(userRepository.update(null));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));





    }
}
