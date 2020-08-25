package lesson11.ex1;

import java.util.Arrays;

public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    //1. RequestRooms()
    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        //System.out.println("Controller.requestRooms() was called");
        Room[] roomsApis0 = apis[0].findRooms(price, persons, city, hotel);
        Room[] roomsApis1 = apis[1].findRooms(price, persons, city, hotel);
        Room[] roomsApis2 = apis[2].findRooms(price, persons, city, hotel);

        Room[] roomsRequestRooms = new Room[roomsApis0.length + roomsApis1.length + roomsApis2.length];

        for (int i = 0; i < roomsApis0.length; i++) {
            roomsRequestRooms[i] = roomsApis0[i];
        }
        for (int i = roomsApis0.length; i < roomsApis0.length + roomsApis1.length; i++) {
            roomsRequestRooms[i] = roomsApis0[i];
        }
        for (int i = roomsApis0.length + roomsApis1.length; i < roomsApis0.length + roomsApis1.length + roomsApis2.length; i++) {
            roomsRequestRooms[i] = roomsApis0[i];
        }

        return roomsRequestRooms;
    }

    //2. check()
    public Room[] check(API api1, API api2) {
        //System.out.println("Controller.check() was called...");

        Room[] a1 = api1.getAll();
        Room[] roomsCheck = new Room[api1.getAll().length];
        int count = 0;
        int countWithoutNull = 0;

        for (int i = 0; i < a1.length; i++) {
            Room[] a2 = api2.findRooms(a1[i].getPrice(), a1[i].getPerson(), a1[i].getCityName(), a1[i].getHotelName());
            for (int j = 0; j < a2.length; j++) {
                if (a1[i] != null && a2[j] != null && a1[i].getPerson() == a2[j].getPerson() &&
                        a1[i].getHotelName() == a2[j].getHotelName() &&
                        a1[i].getCityName() == a2[j].getCityName() &&
                        a1[i].getPrice() == a2[j].getPrice()) {
                    roomsCheck[count] = a1[i];
                    count++;
                    countWithoutNull++;
                }
            }
        }
        return deleteNull(roomsCheck, countWithoutNull);
    }

    //3. cheapestRoom()
    Room cheapestRoom() {
        //System.out.println("cheapestRoom() was called...");

        int minPrise = apis[0].getAll()[0].getPrice();
        Room roomCheapestRoom = apis[0].getAll()[0];

        for (Room el : apis[0].getAll()) {
            if (el.getPrice() < minPrise) {
                roomCheapestRoom = el;
                minPrise = el.getPrice();
            }
        }
        return roomCheapestRoom;
    }

    public static Room[] deleteNull(Room[] firstArray, int countWithoutNull) {

        Room[] arrayWithoutNull = new Room[countWithoutNull];
        int count1 = 0; // Счетчик результирующего массива без нал ячеек
        for (Room el : firstArray) {
            if (el != null) {
                arrayWithoutNull[count1] = el;
                count1++;
            }
        }
        return arrayWithoutNull;
    }
}