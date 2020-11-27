package lesson35.demo;

import lesson35.controller.OrderController;
import lesson35.controller.UserController;
import lesson35.model.Order;
import lesson35.repository.GeneralRepository;
import lesson35.repository.OrderRepository;

import java.util.Date;

public class DemoOrder {
    public static void main(String[] args) throws Exception {
        OrderController orderController = new OrderController();
        OrderRepository orderRepository = new OrderRepository();
        GeneralRepository generalRepository = new GeneralRepository();
        UserController userController = new UserController();

        userController.login("Adriano", "password");

        Date dateFrom = generalRepository.transferDateFromFile("20-12-2020");
        Date dateTo = generalRepository.transferDateFromFile("22-12-2020");
        orderController.bookRoom(1001L, 100, dateFrom, dateTo);
        System.out.println(orderRepository.writeToList("E:/Gromcode/Java Core/DB/OrderDb.txt"));

        orderController.cancelReservation(1002L, 102L);


        userController.logout();
    }
}
