package lesson27.ex3;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo {

    public static void main(String[] args) throws Exception {
        User user1 = new User(1, "Mike", "111");
        User user2 = new User(2, "Dock", "222");
        User user3 = new User(3, "Tom", "333");
        User user4 = new User(0, null, null);

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        //users.add(user4);

        UserRepository userRepository = new UserRepository(users);

        userRepository.update(1, "Michael", "01010");
        for (User el : users) {
            System.out.println(el.toString());
        }
        System.out.println();

        userRepository.delete(3);
        for (User el : users) {
            System.out.println(el.toString());
        }
        System.out.println();

        userRepository.save(6, "666");
        for (User el : users) {
            System.out.println(el.toString());
        }
    }
}
