package lesson9.Ex5UserRepository;

public class Demo {
    // 2.1. Создаем Объкты - массивы пользователей
    static User user0 = new User(1, "Mike", "111");
    static User user1 = new User(2, "Dock", "222");
    static User user3 = new User(3, "Tom", "333");
    static User user2 = null;
    static User user4 = new User(1, "Frida", "777");

    // 2.2. Объединяем массивы пользователей в новый массив
    static User[] users = {user0, user1, user2, user3};

    // 2.3. Создаем объект из массивов
    static UserRepository userRepository = new UserRepository(users);

    // 2.4. Класс мэйн для проверки
    public static void main(String[] args) {
        //System.out.println(userRepository.getUsers().length);
        //printUsers();
        //update(user4);
        delete(3);
        printUsers();
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

    // part 5.1 update
    public static User update(User user) {
        if (findById(user.getId()) == null) { // если юзера нет
            return null;
        }
        // если есть, обновляем и возвращаем. Допустим, что id константа, а обноляются name, sessionId
        for (int i = 0; i < userRepository.getUsers().length; i++) {
            if (userRepository.getUsers()[i].getId() == user.getId()) {
                userRepository.getUsers()[i] = user;
                return userRepository.getUsers()[i];
            }
        }

        return null;
    }

    // part 5.2 delete. Для удаления прописываю значения 0, null, null
    public static void delete(long id) {
        for (int i = 0; i < userRepository.getUsers().length; i++) {
            if (userRepository.getUsers()[i] == null) {
                break;
            }
            if (userRepository.getUsers()[i].getId() == id) {
                userRepository.getUsers()[i] = null;
                return;
            }
        }
    }

    // Печатаем массив юзеров
    public static void printUsers() {
        for (User el : userRepository.getUsers()) {
            if (el != null) {
                System.out.println(el.getId());
                System.out.println(el.getName());
                System.out.println(el.getSessionId());
                System.out.println("--------");
            } else {
                System.out.println("null");
            }
        }
    }
}
