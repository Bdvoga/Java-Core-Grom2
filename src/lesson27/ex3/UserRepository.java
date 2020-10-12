package lesson27.ex3;

import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> users;

    public UserRepository(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public User save(long id, String name) throws Exception {
        if (findById(id) == null) {
            User user = new User(id, name, null);
            users.add(user);
            return user;
        }

        throw new Exception("User id: " + id + " already created");
    }


    public User update(long id, String name, String sessionId) throws Exception {
        if (findById(id) != null) {
            for (User el : users) {
                if (el.getId() == id) {
                    el.setName(name);
                    el.setSessionId(sessionId);
                    return el;
                }
            }
        }

        throw new Exception("User id: " + id + " not found");
    }

    public void delete(long id) throws Exception {
        User user = findById(id);
        if (user != null) {
            users.remove(user);
        } else {
            throw new Exception("User id: " + id + " not found");
        }
    }

    public User findById(long id) {
        for (User el: users) {
            if (el.getId() == id)
                return el;
        }

        return null;
    }
}