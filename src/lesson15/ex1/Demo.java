package lesson15.ex1;

public class Demo {
    public static void main(String[] args) {
        User user = new User(111, "Tom", "aaa");
        User user1 = new User(222, "Dick", "bbb");
        User user2 = new User(333, "Alan", "ccc");
        User user3 = new User(444, "Pit", "ddd");
        User user4 = new User(555, "Sam", "sss");
        User user5 = null;
        User user6 = new User(666, "noname", "fff");

        User[] users = {user, user1, user2, user3, null};

        UserRepository userRepository = new UserRepository(users);

        //Проверяем работу findUser
        System.out.println(userRepository.findUser(user)); // существующий
        System.out.println(userRepository.findUser(user4)); // не существующий
        System.out.println(userRepository.findUser(user5)); // null
        System.out.println();

        //Проверяем работу save
        System.out.println(userRepository.save(user4)); // новый
        System.out.println(userRepository.save(user1)); // существующий
        System.out.println(userRepository.save(user1)); // добавляем null
        for (User el : users) {
            System.out.println(el);
        }
        System.out.println();

        //Проверяем работу update
        System.out.println(userRepository.update(user1)); //юзер есть
        System.out.println(userRepository.update(user6)); //юзера нет
        for (User el : users) {
            System.out.println(el);
        }
        System.out.println();

        //Проверяем работу delete
        userRepository.delete(111); // удаляем существующего
        userRepository.delete(123); // удаляем не существующего
        for (User el : users) {
            System.out.println(el);
        }

    }
}
