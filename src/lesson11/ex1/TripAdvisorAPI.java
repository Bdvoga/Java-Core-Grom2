package lesson11.ex1;

//import static lesson11.ex1.Controller.deleteNull;

public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int countWithoutNull = 0;
        Room[] foolRoomsTripAdvisorAPI = new Room[rooms.length];
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPrice() == price &&
                    (rooms[i].getPerson() <= persons + 1 && rooms[i].getPerson() >= persons - 1) &&
                    rooms[i].getCityName() == city &&
                    rooms[i].getHotelName() == hotel) {
                foolRoomsTripAdvisorAPI[i] = rooms[i];
                countWithoutNull++;
            }
        }
        Room[] roomsTripAdvisorAPI = new Room[countWithoutNull];
        int count = 0;
        for (Room el : foolRoomsTripAdvisorAPI) {
            if (el != null && el.getPrice() == price &&
                    (el.getPerson() <= persons + 1 && el.getPerson() >= persons - 1) &&
                    el.getCityName() == city &&
                    el.getHotelName() == hotel) {
                roomsTripAdvisorAPI[count] = el;
                count++;
            }
        }
        //System.out.println("TripAdvisorAPI  was called...");
        return roomsTripAdvisorAPI;
    }

    @Override
    public Room[] getAll() {
        Room[] roomsGetAll = new Room[rooms.length];
        for (int i = 0; i < rooms.length; i++) {
            roomsGetAll[i] = rooms[i];
        }
        return roomsGetAll;
    }
}