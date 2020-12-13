package lesson35.repository;

import lesson35.model.*;

import java.io.*;
import java.util.ArrayList;

public class UserRepository extends RepositoryAbstract {

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

    //    @Override
//    public ArrayList<User> mapObject(String path) throws Exception {
//        ArrayList<User> users = new ArrayList<>();
//        int count = 0;// счетчик строк файла
//        UserType userType;
//        try {
//            for (String[] el : readFile(path)) {
//                if (el[4].equals("ADMIN")) {
//                    userType = UserType.ADMIN;
//                } else {
//                    userType = UserType.USER;
//                }
//                User user = new User(Long.parseLong(el[0]), el[1], el[2], el[3], userType);
//                users.add(user);
//                count++;
//            }
//        } catch (ArrayIndexOutOfBoundsException e) {
//            throw new Exception("Неправильный формат данных в файле " + path + " в строке " + count);
//        } catch (NumberFormatException e) {
//            throw new Exception("Неправильный формат id в файле " + path + " в строке " + count);
//        }
//
//        return users;
//    }
}
