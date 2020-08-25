package lesson9.Ex5UserRepository;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    // part 5.1 update
    public User update(User user) {
        if (findById(user.getId()) == null) {

            return null;
        }
        // если есть, обновляем и возвращаем.
        for (int i =0; i < getUsers().length; i++) {
            if (getUsers()[i].getId() == user.getId()) {
                getUsers()[i] = user;

                return getUsers()[i];
            }
        }

        return null;
    }

    // part 5.2 delete
    public void delete(long id) {
        for (int i = 0; i < getUsers().length; i++) {
            if (getUsers()[i] == null) {
                break;
            }
            if (getUsers()[i].getId() == id) {
                getUsers()[i] = null;
                return;
            }
        }
    }

    private User findById(long id) {
        for (User el : users) {
            if (el == null) {
                return null;
            }
            if (el.getId() == id)
                return el;
        }
        return null;
    }
}