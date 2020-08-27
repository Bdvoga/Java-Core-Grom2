package lesson11.ex1;

//import static lesson11.ex1.Controller.deleteNull;

public class TripAdvisorAPI implements API {
    private Room[] rooms1;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms1 = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int countWithoutNull = 0;
        Room[] foolRoomsTripAdvisorAPI = new Room[rooms1.length];
        for (int i = 0; i < rooms1.length; i++) {
            if (rooms1[i].getPrice() == price &&
                    (rooms1[i].getPerson() <= persons + 1 && rooms1[i].getPerson() >= persons - 1) &&
                    rooms1[i].getCityName() == city &&
                    rooms1[i].getHotelName() == hotel) {
                foolRoomsTripAdvisorAPI[i] = rooms1[i];
                countWithoutNull++;
            }
        }
        Room[] roomsTripAdvisorAPI = new Room[countWithoutNull];
        int count = 0;
        for (Room el : foolRoomsTripAdvisorAPI) {
            if (el != null) {
                roomsTripAdvisorAPI[count] = el;
                count++;
            }
        }
        //System.out.println("TripAdvisorAPI  was called...");
        return roomsTripAdvisorAPI;
    }

    @Override
    public Room[] getAll() {
        Room[] roomsGetAll = new Room[rooms1.length];
        for (int i = 0; i < rooms1.length; i++) {
            roomsGetAll[i] = rooms1[i];
        }
        return roomsGetAll;
    }
}