package lesson35.demo;

import lesson35.controller.UserController;
import lesson35.model.*;
import lesson35.repository.UserRepository;

import java.util.ArrayList;
import java.util.Date;

public class DemoUser {

    //DemoUser demoUser = new DemoUser();

    public static void main(String[] args) throws Exception {
        UserController userController = new UserController();

//        ArrayList<User> users = userRepository.writeToList("E:/Gromcode/Java Core/DB/UserDb.txt");
//        System.out.println(users);

        userController.login("Adriano", "password");
        //System.out.println(Session.getUser());

        //register
        User newUser = new User(0L, "Mike2", "123", "Ukraine", UserType.USER);
        userController.registerUser(newUser);

        userController.logout();
    }
}