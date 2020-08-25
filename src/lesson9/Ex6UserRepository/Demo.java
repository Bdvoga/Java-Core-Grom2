package lesson9.Ex6UserRepository;

public class Demo {
    // 2.1. Создаем Объкты - массивы пользователей
    static User user = new User(1, "Mike", "111");
    static User user1 = new User(2, "Dock", "222");
    static User user2 = new User(3, "Tom", "333");
    static User user3 = new User(0, null, null);

    // 2.2. Объединяем массивы пользователей в новый массив
    //static User[] users = new User[4];
    static User[] users = {user, user1, user2, user3};

    // 2.3. Создаем объект из массивов
    static UserRepository userRepository = new UserRepository(users);

    // 2.4. Класс мэйн для проверки
    public static void main(String[] args) {
        System.out.println(update(1, "Michael", "01010"));
    }

   // 3.2 Есть ли такой юзер (проверяем по id)
    public static String findById(long id) {
        for (User el: userRepository.getUsers()) {
            if (el.getId() == id)
                return el.getName();
        }
        return null;
    }

    // part 5.1 update
    public static User update(long id, String name, String sessionId) {
        if (findById(id) != null) {
            // если есть, обновляем и возвращаем
            for (User el : userRepository.getUsers()) {
                if (el.getId() == id) {
                    el.setName(name);
                    el.setSessionId(sessionId);
                    return el;
                }
            }
        }

        return null;
    }

    // part 5.2 delete
    public static void delete(long id) {
        if (findById(id) != null) {
            for (User el : userRepository.getUsers()) {
                if (el.getId() == id) {
                    el.setId(0);
                    el.setName(null);
                    el.setSessionId(null);
                }
            }
        }
    }

    // part 4.
    public static User save(long id, String name) {
        // Есть ли такой ид в базе
        if (findById(id) != null) {
            // Проверяем, есть ли свободные ячейки в массиве
            for (User el : userRepository.getUsers()) {
                if (el.getName() == null) {
                    el.setId(id);
                    el.setName(name);

                    return el;
                }
            }
        }

        return null;
    }

}
