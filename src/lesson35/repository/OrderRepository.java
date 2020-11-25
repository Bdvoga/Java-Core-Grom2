package lesson35.repository;

import lesson35.model.Order;
import lesson35.model.Room;
import lesson35.model.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class OrderRepository {

    GeneralRepository generalRepository = new GeneralRepository();
    UserRepository userRepository = new UserRepository();
    RoomRepository roomRepository = new RoomRepository();
    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        String path = "E:/Gromcode/Java Core/DB/OrderDb.txt";
        ArrayList<Order> orders = readFileOrder(path);
        ArrayList<Room> rooms = roomRepository.readFileRoom("E:/Gromcode/Java Core/DB/RoomDb.txt");
        Room room = generalRepository.findById(rooms, roomId);
        ArrayList<User> users = userRepository.readFileUser("E:/Gromcode/Java Core/DB/UserDb.txt");

        long orderId = generalRepository.generationId(orders);
        User user = generalRepository.findById(users, userId);
        double moneyPaid = ((dateTo.getTime() - dateFrom.getTime()) / 86400000) * generalRepository.findById(rooms, roomId).getPrice();

        orders.add(new Order(orderId, user, room, dateFrom, dateTo, moneyPaid));

        generalRepository.writeListToFileBd(orders, path);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        ArrayList<Order> orders = readFileOrder("E:/Gromcode/Java Core/DB/OrderDb.txt");
        for (Order el : orders) {
            if (el.getRoom().getId() == roomId && el.getUser().getId() == userId) {
                orders.remove(el);
                generalRepository.writeListToFileBd(orders, "E:/Gromcode/Java Core/DB/OrderDb.txt");
                return;
            }
        }
        throw new Exception("Заказ не найден");
    }

    public ArrayList<Order> readFileOrder(String path) throws Exception { //Hotel
        String pathUserDb = "E:/Gromcode/Java Core/DB/UserDb.txt";
        String pathRoomDb = "E:/Gromcode/Java Core/DB/RoomDb.txt";
        ArrayList<Order> orders = new ArrayList<>();

        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");

                User user = generalRepository.findById(userRepository.readFileUser(pathUserDb), Long.parseLong(strings[1]));
                Room room = generalRepository.findById(roomRepository.readFileRoom(pathRoomDb), Long.parseLong(strings[2]));
                Order order = new Order(Long.parseLong(strings[0]), user, room,
                        generalRepository.transferDateFromFile(strings[3]),
                        generalRepository.transferDateFromFile(strings[4]), Double.parseDouble(strings[5]));
                orders.add(order);
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

        return orders;
    }
}
