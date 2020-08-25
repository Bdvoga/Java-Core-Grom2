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

        Room[] roomsRequestRooms = new Room[apis[0].getAll().length * 3];
        int shift0 = apis[0].findRooms(price, persons, city, hotel).length;
        int shift1 = apis[1].findRooms(price, persons, city, hotel).length;
        int k = 0;
        int l = 0;
        int countWithoutNull = 0;

        for (int i = 0; i < 3; i++) {
            if (i == 1)
                l = 1;
            else if (i == 2)
                k = 1;

            for (int j = 0; j < apis[i].findRooms(price, persons, city, hotel).length; j++) {
                roomsRequestRooms[j + shift0 * k + shift1 * l] = apis[i].findRooms(price, persons, city, hotel)[j];
                countWithoutNull++;
            }
        }
        return deleteNull(roomsRequestRooms, countWithoutNull);
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