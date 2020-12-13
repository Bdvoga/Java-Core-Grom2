package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.model.Session;
import lesson35.model.User;
import lesson35.repository.UserRepository;
import lesson35.service.UserService;

import java.util.ArrayList;
import java.util.Date;

public class UserController {
//    registerUser(User user) - регистрация пользователя в системе +-
//    void login(String userName, String password) - логин пользователя +
//    void logout() +

    private UserService userService = new UserService();
    private UserRepository userRepository = new UserRepository();

    public User registerUser(User user) throws Exception {
        return userService.registerUser(user);
    }

    public void login(String userName, String password) throws Exception {
        userService.login(userName, password);
    }

    public void logout() {
        Session.setUser(null);
    }


}
