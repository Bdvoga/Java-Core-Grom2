package lesson11.ex1;

//import static lesson11.ex1.Controller.deleteNull;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int countWithoutNull = 0;
        Room[] fullRoomsGoogleAPI = new Room[rooms.length];
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getPrice() == price &&
                    rooms[i].getPerson() == persons &&
                    rooms[i].getCityName() == city &&
                    rooms[i].getHotelName() == hotel) {
                fullRoomsGoogleAPI[i] = rooms[i];
                countWithoutNull++;
            }
        }

        Room[] roomsGoogleAPI = new Room[countWithoutNull];
        int count = 0;
        for (Room el : fullRoomsGoogleAPI) {
            if (el != null && el.getPrice() == price &&
                    el.getPerson() == persons &&
                    el.getCityName() == city &&
                    el.getHotelName() == hotel) {
                roomsGoogleAPI[count] = el;
                count++;
            }
        }
        //System.out.println("GoogleAPI  was called...");
        return roomsGoogleAPI;
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