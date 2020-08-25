package lesson9.Ex2SearchUser;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    // 2.5. Метод для получения массива имен
    public String[] getUserNames() {
        String[] arrayName = new String[getUsers().length]; // Создаем массив для имен пользователей

        // заполняем массив id пользователей
        for (int i = 0; i < getUsers().length; i++) {
            arrayName[i] = getUsers()[i].getName();
        }

        return arrayName;
    }

    // 2.6. Метод для получения массива id
    public long[] getUserIds() {
        long[] arrayId = new long[getUsers().length]; // Создаем массив для имен пользователей

        // заполняем массив id пользователей
        for (int i = 0; i < getUsers().length; i++) {
            arrayId[i] = getUsers()[i].getId();
        }

        return arrayId;
    }

    // 2.7. Метода для получ. имени по ид
    public String getUserNameById(long id) {
        String str = "";
        for (int i = 0; i < getUsers().length; i++) {
            if (getUsers()[i].getId() == id)
                str = getUsers()[i].getName();
        }
        return str;
    }

}