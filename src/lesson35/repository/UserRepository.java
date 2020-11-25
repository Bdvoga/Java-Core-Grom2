package lesson35.repository;

import lesson35.model.*;

import java.io.*;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.DataFormatException;

public class UserRepository {
    //считывание данных - считывание файла
    //обработка данных - маппинг данных (преобразование считанной строки из файла бд в объект)

    GeneralRepository generalRepository = new GeneralRepository();

    public User registerUser(User user) throws Exception {
        // на вход подается юзер без id, id генерит система
        //save user to db (file)
        ArrayList<User> users = readFileUser("E:/Gromcode/Java Core/DB/UserDb.txt");
        user.setId(generalRepository.generationId(users));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("E:/Gromcode/Java Core/DB/UserDb.txt", true))) {
            bw.append("\n");
            bw.append(user.toString());
        } catch (IOException e) {
            throw new IOException("Обшибка записи");
        }

        return user;
    }

    public ArrayList<User> readFileUser(String path) throws Exception { //User
        ArrayList<User> users = new ArrayList<>();
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            UserType userType;
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                if (strings[4].equals("ADMIN")) {
                    userType = UserType.ADMIN;
                } else {
                    userType = UserType.USER;
                }
                User user = new User(Long.parseLong(strings[0]), strings[1], strings[2], strings[3], userType);
                users.add(user);
                count++;
            }
        } catch (FileNotFoundException e) {
            throw new Exception("File doesn't exist");
        } catch (IOException e) {
            throw new IOException("Reading from file " + path + " filed");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Неправильный формат данных в файле " + path + " в строке " + count);
        } catch (NumberFormatException e) {
            throw new Exception("Неправильный формат id в файле " + path + " в строке " + count);
        }

        return users;
    }
}
