package lesson35.service;

import lesson35.model.*;
import lesson35.repository.UserRepository;

import java.util.ArrayList;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public User registerUser(User user) throws Exception {
        //все ли поля заполнены
        if (user.getUserName() != null && user.getPassword() != null &&
                user.getCountry() != null && user.getUserType() != null) {
            return userRepository.registerUser(user);
        } else {
            throw new Exception("Ошибка! Не все поля заполнены!");
        }
    }

        public void login(String userName, String password) throws Exception {
        userRepository.login(userName, password);
    }
}
