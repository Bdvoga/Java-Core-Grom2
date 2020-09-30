package lesson22.repository;

import lesson20.task1.exception.InternalServerException;
import lesson22.repository.exception.BadRequestException;
import lesson22.repository.exception.UserNotFoundException;

public class UserRepository {
    private static User[] users = new User[10];

    public static User save(User user) throws Exception{
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

        throw new InternalServerException("Not enough space to save user with id: " + user.getId());
    }

    public static User update(User user) throws Exception {
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

        throw new InternalServerException("Unexpected error");
    }

    // delete
    public static void delete(long id) throws Exception {

        findById(id);

        for (int i = 0; i < getUsers().length; i++) {
            if (getUsers()[i].getId() == id) {
                getUsers()[i] = null;
                return;
            }
        }
    }

    public static User findById(long id) throws Exception {
        for (User user : users) {
            if (user != null && user.getId() == id)
                return user;
        }
        throw new UserNotFoundException("User with id: " + id + " not found");
    }

    public static User[] getUsers() {
        return users;
    }
}