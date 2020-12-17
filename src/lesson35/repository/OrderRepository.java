package lesson35.repository;

import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class OrderRepository extends GeneralRepository {
    //GeneralRepository generalRepository = new GeneralRepository();
    UserRepository userRepository = new UserRepository();
    RoomRepository roomRepository = new RoomRepository();

    public void bookRoom(long roomId, long userId, String dateFrom, String dateTo) throws Exception {
        Date dateFromConverted = transferDateFromFile(dateFrom);
        Date dateToConverted = transferDateFromFile(dateTo);
        String path = "E:/Gromcode/Java Core/DB/OrderDb.txt";
        ArrayList<Order> orders = getAllObjects(path);
        ArrayList<Room> rooms = roomRepository.getAllObjects("E:/Gromcode/Java Core/DB/RoomDb.txt");
        Room room = (Room) findById(rooms, roomId);
        ArrayList<User> users = userRepository.getAllObjects("E:/Gromcode/Java Core/DB/UserDb.txt");

        long orderId = generationId(orders);
        User user = (User) findById(users, userId);
        double moneyPaid = ((dateToConverted.getTime() - dateFromConverted.getTime()) / 86400000) * ((Room) findById(rooms, roomId)).getPrice();

        Order order = new Order(orderId, user, room, dateFromConverted, dateToConverted, moneyPaid);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.append("\n");
            bw.append(order.toString());
        } catch (IOException e) {
            throw new IOException("Обшибка записи в файл " + path);
        }
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        ArrayList<Order> orders = getAllObjects("E:/Gromcode/Java Core/DB/OrderDb.txt");
        for (Order el : orders) {
            if (el.getRoom().getId() == roomId && el.getUser().getId() == userId) {
                orders.remove(el);

                //TODO
                writeListToFileBd(orders, "E:/Gromcode/Java Core/DB/OrderDb.txt");
                return;
            }
        }
    }

    @Override
    public Order getMappedObject(String[] object) throws Exception {
        String pathUserDb = "E:/Gromcode/Java Core/DB/UserDb.txt";
        String pathRoomDb = "E:/Gromcode/Java Core/DB/RoomDb.txt";
        try {
            User user = (User) findById(userRepository.getAllObjects(pathUserDb), Long.parseLong(object[1]));
            Room room = (Room) findById(roomRepository.getAllObjects(pathRoomDb), Long.parseLong(object[2]));
            return new Order(Long.parseLong(object[0]), user, room,
                    transferDateFromFile(object[3]),
                    transferDateFromFile(object[4]), Double.parseDouble(object[5]));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Неправильный формат данных в файле E:/Gromcode/Java Core/DB/OrderDb.txt");
        } catch (NumberFormatException e) {
            throw new Exception("Неправильный формат id в файле E:/Gromcode/Java Core/DB/OrderDb.txt");
        }
    }

//    public ArrayList<Order> mapObject(String path) throws Exception {
//        String pathUserDb = "E:/Gromcode/Java Core/DB/UserDb.txt";
//        String pathRoomDb = "E:/Gromcode/Java Core/DB/RoomDb.txt";
//        ArrayList<Order> orders = new ArrayList<>();
//        int count = 0;
//        ArrayList<String[]> arrayList = readFile(path);
//        try {
//            for (String[] el : arrayList) {
//                User user = (User) generalRepository.findById(userRepository.mapObject(pathUserDb), Long.parseLong(el[1]));
//                Room room = (Room) generalRepository.findById(roomRepository.mapObject(pathRoomDb), Long.parseLong(el[2]));
//                Order order = new Order(Long.parseLong(el[0]), user, room,
//                        generalRepository.transferDateFromFile(el[3]),
//                        generalRepository.transferDateFromFile(el[4]), Double.parseDouble(el[5]));
//                orders.add(order);
//                count++;
//            }
//        } catch (ArrayIndexOutOfBoundsException e) {
//            throw new Exception("Неправильный формат данных в файле " + path + " в строке " + count);
//        } catch (NumberFormatException e) {
//            throw new Exception("Неправильный формат id в файле " + path + " в строке " + count);
//        }
//
//        return orders;
//    }
}
