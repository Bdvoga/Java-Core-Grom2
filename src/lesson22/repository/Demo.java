package lesson22.repository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {

        //UserRepository userRepository = new UserRepository();

        User user1 = new User(1001, "Daniil", "237464jdhfjdkdks");
        //User user1 = null;
        UserRepository.save(user1);
        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        User user2 = new User(1002, "Andrey", "skdjd6728");
        UserRepository.save(user2);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        User user3 = new User(1001, "Test", "237464jdhfjdkdks");
        UserRepository.update(user3);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));
    }
}
