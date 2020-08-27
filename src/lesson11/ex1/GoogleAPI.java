package lesson11.ex1;

//import static lesson11.ex1.Controller.deleteNull;

public class GoogleAPI implements API {
    private Room[] rooms2;

    public GoogleAPI(Room[] rooms) {
        this.rooms2 = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int countWithoutNull = 0;
        Room[] fullRoomsGoogleAPI = new Room[rooms2.length];
        for (int i = 0; i < rooms2.length; i++) {
            if (rooms2[i].getPrice() == price &&
                    rooms2[i].getPerson() == persons &&
                    rooms2[i].getCityName() == city &&
                    rooms2[i].getHotelName() == hotel) {
                fullRoomsGoogleAPI[i] = rooms2[i];
                countWithoutNull++;
            }
        }

        Room[] roomsGoogleAPI = new Room[countWithoutNull];
        int count = 0;
        for (Room el : fullRoomsGoogleAPI) {
            if (el != null) {
                roomsGoogleAPI[count] = el;
                count++;
            }
        }
        //System.out.println("GoogleAPI  was called...");
        return roomsGoogleAPI;
    }

    @Override
    public Room[] getAll() {
        Room[] roomsGetAll = new Room[rooms2.length];
        for (int i = 0; i < rooms2.length; i++) {
            roomsGetAll[i] = rooms2[i];
        }
        return roomsGetAll;
    }
}