package lesson20.task1;

import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServelException;
import lesson20.task1.exception.UserNotFoundException;

public class UserRepository {
    private User[] users = new User[10];

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    // save
    public User save(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        } catch (UserNotFoundException e) {
            // Правило хорошего тона!
            // Не оставлять блок catch пустым
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }

        for (int i = 0; i < getUsers().length; i++) {
            if (getUsers()[i] == null) {
                getUsers()[i] = user;
                return getUsers()[i];
            }
        }
        throw new InternalServelException("Not enough space to save user with id: " + user.getId());
    }

    // update
    public User update(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can't update null user");

        findById(user.getId());

        // если есть, обновляем и возвращаем.
        for (int i =0; i < getUsers().length; i++) {
            if (getUsers()[i].getId() == user.getId()) {
                getUsers()[i] = user;
                return getUsers()[i];
            }
        }
        throw new InternalServelException("Unexpected error");
    }

    // delete
    public void delete(long id) throws Exception {

        findById(id);

        for (int i = 0; i < getUsers().length; i++) {
            if (getUsers()[i].getId() == id) {
                getUsers()[i] = null;
                return;
            }
        }
    }

    public User findById(long id) throws Exception {
        for (User user : users) {
            if (user != null && id == user.getId()) {
                return user;
            }
        }

        throw new UserNotFoundException("User with id: " + id + " not found");
    }
}
