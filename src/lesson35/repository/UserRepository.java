package lesson35.repository;

import lesson35.model.*;

import java.io.*;
import java.util.ArrayList;

public class UserRepository extends RepositoryAbstract<IdEntity> {

    GeneralRepository<User> generalRepository = new GeneralRepository<User>();

    @Override
    public User getMappedObject(String[] object) throws Exception {
        UserType userType = UserType.USER;
        if (object[4].equals("ADMIN")) {
            userType = UserType.ADMIN;
        }

        try {
            return new User(Long.parseLong(object[0]), object[1], object[2], object[3], userType);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Неправильный формат данных в файле E:/Gromcode/Java Core/DB/UserDb.txt");
        } catch (NumberFormatException e) {
            throw new Exception("Неправильный формат id в файле E:/Gromcode/Java Core/DB/UserDb.txt");
        }
    }

    public User registerUser(User user) throws Exception {
        // на вход подается юзер без id, id генерит система
        //save user to db (file)
        ArrayList<User> users = getAllObjects("E:/Gromcode/Java Core/DB/UserDb.txt");
        user.setId(generalRepository.generationId(users));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("E:/Gromcode/Java Core/DB/UserDb.txt", true))) {
            bw.append("\n");
            bw.append(user.toString());
        } catch (IOException e) {
            throw new IOException("Обшибка записи");
        }

        return user;
    }

    public void login(String userName, String password) throws Exception {
        ArrayList<User> arrayList = getAllObjects("E:/Gromcode/Java Core/DB/UserDb.txt");
        for (User el : arrayList) {
            if (el.getUserName().equals(userName) && el.getPassword().equals(password)) {
                Session.setUser(el);
                return;
            }
        }
        System.err.println("Данные не найдены");

    }

}
