package lesson35.controller;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.service.RoomService;

import java.util.ArrayList;

public class RoomController {
    // для ADMIN
//    addRoom(Room room) +
//    deleteRoom(long RoomId) +

//List findRooms(Filter filter) - нахождения комнат по параматрам фильтра

    RoomService roomService = new RoomService();

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        return roomService.findRooms(filter);
    }

    public Room addRoom(Room room) throws Exception {
        return roomService.addRoom(room);
    }

    public void deleteRoom(long roomId) throws Exception {
        roomService.deleteRoom(roomId);
    }
}
