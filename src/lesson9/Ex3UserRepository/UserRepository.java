package lesson9.Ex3UserRepository;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    // 3.1
    public User getUserByName(String name) {
        for (User el : getUsers()) {
            if (el.getName() == name)
                return el;
        }
        return null;
    }

    // 3.2
    public User getUserById(long id) {
        for (User el : getUsers()) {
            if (el.getId() == id)
                return el;
        }
        return null;
    }

    // 3.3
    public User getUserBySessionId(String session) {
        for (User el : getUsers()) {
            if (el.getSessionId() == session)
                return el;
        }
        return null;
    }
}