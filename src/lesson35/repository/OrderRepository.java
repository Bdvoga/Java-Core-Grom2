package lesson35.repository;

import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;

import java.util.ArrayList;
import java.util.Date;

public class OrderRepository extends GeneralRepositoryAbstract {
    GeneralRepository generalRepository = new GeneralRepository();
    UserRepository userRepository = new UserRepository();
    RoomRepository roomRepository = new RoomRepository();

    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        String path = "E:/Gromcode/Java Core/DB/OrderDb.txt";
        ArrayList<Order> orders = writeToList(path);
        ArrayList<Room> rooms = roomRepository.writeToList("E:/Gromcode/Java Core/DB/RoomDb.txt");
        Room room = generalRepository.findById(rooms, roomId);
        ArrayList<User> users = userRepository.writeToList("E:/Gromcode/Java Core/DB/UserDb.txt");

        long orderId = generalRepository.generationId(orders);
        User user = generalRepository.findById(users, userId);
        double moneyPaid = ((dateTo.getTime() - dateFrom.getTime()) / 86400000) * generalRepository.findById(rooms, roomId).getPrice();

        orders.add(new Order(orderId, user, room, dateFrom, dateTo, moneyPaid));

        generalRepository.writeListToFileBd(orders, path);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        ArrayList<Order> orders = writeToList("E:/Gromcode/Java Core/DB/OrderDb.txt");
        for (Order el : orders) {
            if (el.getRoom().getId() == roomId && el.getUser().getId() == userId) {
                orders.remove(el);
                generalRepository.writeListToFileBd(orders, "E:/Gromcode/Java Core/DB/OrderDb.txt");
                return;
            }
        }
    }

    @Override
    public ArrayList<Order> writeToList(String path) throws Exception {
        String pathUserDb = "E:/Gromcode/Java Core/DB/UserDb.txt";
        String pathRoomDb = "E:/Gromcode/Java Core/DB/RoomDb.txt";
        ArrayList<Order> orders = new ArrayList<>();
        int count = 0;
        try {
            for (String[] el : readFile(path)) {
                User user = generalRepository.findById(userRepository.writeToList(pathUserDb), Long.parseLong(el[1]));
                Room room = generalRepository.findById(roomRepository.writeToList(pathRoomDb), Long.parseLong(el[2]));
                Order order = new Order(Long.parseLong(el[0]), user, room,
                        generalRepository.transferDateFromFile(el[3]),
                        generalRepository.transferDateFromFile(el[4]), Double.parseDouble(el[5]));
                orders.add(order);
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Неправильный формат данных в файле " + path + " в строке " + count);
        } catch (NumberFormatException e) {
            throw new Exception("Неправильный формат id в файле " + path + " в строке " + count);
        }

        return orders;
    }
}
