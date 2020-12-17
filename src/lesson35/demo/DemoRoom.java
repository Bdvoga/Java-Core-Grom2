package lesson35.demo;

import lesson35.controller.RoomController;
import lesson35.controller.UserController;
import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.repository.RoomRepository;
import lesson35.repository.UserRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DemoRoom {
    public static void main(String[] args) throws Exception {
        RoomController roomController = new RoomController();
        UserController userController = new UserController();

//        userController.login("Adriano", "password");



        //Admin - addRoom
//        Hotel hotel1 = new Hotel(101L,"Mir","Ukraine","Kyiv","Street2");
//        Room room = new Room(0L, 3,33.00,true,false,new Date(),hotel1);
//        System.out.println(roomController.addRoom(room));

        //Admin - deleteRoom
        roomController.deleteRoom(1009L);

        //List findRooms(Filter filter)
//        Date dateFrom = new SimpleDateFormat("dd-MM-yyyy").parse("30-11-2020");
//        Filter filter = new Filter(2,50.0,false,
//                false,dateFrom,"Belarus","Grodno");
//
//        System.out.println(roomController.findRooms(filter));

        //userController.logout();
    }

}
