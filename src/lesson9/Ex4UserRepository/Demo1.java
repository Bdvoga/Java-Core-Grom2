package lesson9.Ex4UserRepository;

public class Demo1 {
    public static void main(String[] args) {
        User user1 = new User(1, "Dock", "111");
        User user2 = new User(2, "Tom", "222");
        User user3 = new User(3, "Fred", "333");

        User[] users = new User[5];
        users[0] = user1;
        users[1] = user2;
        users[2] = user3;

        UserRepository userRepository = new UserRepository(users);

        System.out.println(userRepository.getUsers()[3]);

    }

}
