package lesson35.controller;

import lesson35.repository.OrderRepository;
import lesson35.service.OrderService;

import java.util.Date;

public class OrderController {
//    void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) +-
//    - бронирование комнаты, создание нового заказа
//    void cancelReservation(long roomId, long userId) - отмена брони комнаты, удаление заказа ++

    OrderService orderService = new OrderService();

    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        orderService.bookRoom(roomId, userId, dateFrom, dateTo);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        orderService.cancelReservation(roomId, userId);
    }
}
