package lesson35.service;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.repository.RoomRepository;

import java.util.ArrayList;

public class RoomService {
    RoomRepository roomRepository = new RoomRepository();
    GeneralService generalService = new GeneralService();

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        //Залогинен ли юзер
        //Все ли поля заполнены

        generalService.verification();
        if (filter.getNumberOfGuests() != 0 && filter.getPrice() != 0.0 && filter.getBreakfastIncluded() != null &&
                filter.getPetsAllowed() != null && filter.getDateAvailableFrom() != null &&
                filter.getCountry() != null && filter.getCity() != null) {
            return roomRepository.findRooms(filter);
        } else {
            throw new Exception("Не все поля заполнены!");
        }
    }

    public Room addRoom(Room room) throws Exception {
        //залогинен ли Админ?
        //check business logic - все ли поля заполнены (кроме id)
        generalService.verificationAdmin();
        if (room.getNumberOfGuests() != 0 && room.getPrice() != 0 && room.getBreakfastIncluded() != null &&
                room.getPetsAllowed() != null && room.getDateAvailableFrom() != null && room.getHotel() != null) {
            return roomRepository.addRoom(room);
        } else {
            throw new Exception("Ошибка! Не все поля заполнены!");
        }
    }

    public void deleteRoom(long roomId) throws Exception {
        generalService.verificationAdmin();
        roomRepository.deleteRoom(roomId);
    }
}
