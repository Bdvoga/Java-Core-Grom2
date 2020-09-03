package lesson15.ex2;

//import static lesson11.ex1.Controller.deleteNull;

public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] foolRoomsBookingComAPI = new Room[rooms.length];
        int countWithoutNull = 0;
        for (int i = 0; i < rooms.length; i++) {
            if ((rooms[i].getPrice() >= price - 100 && rooms[i].getPrice() <= price + 100) &&
                    rooms[i].getPerson() == persons &&
                    rooms[i].getCityName() == city &&
                    rooms[i].getHotelName() == hotel) {
                foolRoomsBookingComAPI[i] = rooms[i];
                countWithoutNull++;
            }
        }
        Room[] roomsBookingComAPI = new Room[countWithoutNull];
        int count = 0;
        for (Room el : foolRoomsBookingComAPI) {
            if (el != null) {
                roomsBookingComAPI[count] = el;
                count++;
            }
        }
        //System.out.println("BookingComAPI was called...");
        return roomsBookingComAPI;
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