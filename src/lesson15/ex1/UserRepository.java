package lesson15.ex1;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public User findUser(User user) {
        for (User el : users) {
            if (el != null && el.equals(user))
                return el;
        }
        return null;
    }

    public User save(User user) {
        if (user == null || findUser(user) != null) {
            return null;
        }
        for (int i = 0 ; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return users[i];
            }
        }
        return null;
    }

    public User update(User user) {
        for (User el : users) {
            if (el.equals(user)) {
                el.setSessionId("asdfg");
                return el;
            }
        }
        return null;
    }

    public void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getId() == id) {
                users[i] = null;
            }
        }
    }
}
