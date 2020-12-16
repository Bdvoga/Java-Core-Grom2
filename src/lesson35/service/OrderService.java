package lesson35.service;

import lesson35.model.Room;
import lesson35.model.Session;
import lesson35.repository.GeneralRepository;
import lesson35.repository.OrderRepository;
import lesson35.repository.RoomRepository;

import java.util.ArrayList;
import java.util.Date;

public class OrderService {

    OrderRepository orderRepository = new OrderRepository();
    GeneralRepository generalRepository = new GeneralRepository();
    GeneralService generalService = new GeneralService();
    RoomRepository roomRepository = new RoomRepository();

    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        generalService.verification();

        //Есть ли такая комната
//        ArrayList<Room> rooms = roomRepository.writeToList("E:/Gromcode/Java Core/DB/RoomDb.txt");
//        if (generalRepository.findById(rooms,roomId) == null) {
//            throw new Exception("Такой комнаты не существует");
//        }
//
//        //Сбводна ли с даты dateFrom
//        if (generalRepository.findById(rooms,roomId).getDateAvailableFrom().getTime() > dateFrom.getTime()) {
//            throw new Exception("На указанные даты комната не доступна");
//        }

        orderRepository.bookRoom(roomId, userId, dateFrom, dateTo);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        generalService.verification();
        orderRepository.cancelReservation(roomId, userId);
    }
}
