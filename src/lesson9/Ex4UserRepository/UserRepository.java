package lesson9.Ex4UserRepository;

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

    public User save(User user) {
        if (findById(user.getId()) != null) {
            return null;
        }
        for (int i = 0; i < getUsers().length; i++) {
            if (getUsers()[i] == null) {
                getUsers()[i] = user;
                return getUsers()[i];
            }
        }

        return null;
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