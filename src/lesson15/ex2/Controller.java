package lesson15.ex2;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    //1. RequestRooms()
    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        //System.out.println("Controller.requestRooms() was called");

        int lengthRequestRooms = 0;
        for (API api : apis) {
            lengthRequestRooms += api.findRooms(price, persons, city, hotel).length;
        }

        Room[] requestRooms = new Room[lengthRequestRooms];

        int count = 0;
        for (int i = 0; i < 3; i++) {
            apis[i].findRooms(price, persons, city, hotel);
            for (int j = 0; j < apis[i].findRooms(price, persons, city, hotel).length; j++) {
                requestRooms[count] = apis[i].findRooms(price, persons, city, hotel)[j];
                count++;
            }
        }
        return requestRooms;
    }

    //2. check()
    public Room[] check(API api1, API api2) {
        //System.out.println("Controller.check() was called...");

        Room[] fullRoomsCheck = new Room[api1.getAll().length];
        int count = 0;
        for (Room el1 : api1.getAll()) {
            for (Room el2 : api2.getAll()) {
                if (el1.equals(el2)) {
                    fullRoomsCheck[count] = el1;
                    count++;
                }
            }
        }
        Room[] roomsCheck = new Room[count];
        count = 0;
        for (Room el : fullRoomsCheck) {
            if (el != null) {
                roomsCheck[count] = el;
                count++;
            }
        }
        return roomsCheck;
    }

    //3. cheapestRoom()
    public Room cheapestRoom() {
        //System.out.println("cheapestRoom() was called...");

        int minPrise = apis[0].getAll()[0].getPrice();
        Room roomCheapestRoom = apis[0].getAll()[0];

        for (API api : apis) {
            for (Room el : api.getAll()) {
                if (el.getPrice() < minPrise) {
                    roomCheapestRoom = el;
                    minPrise = el.getPrice();
                }
            }
        }
        return roomCheapestRoom;
    }
}