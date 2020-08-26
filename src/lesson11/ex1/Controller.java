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

        Room[] a1 = api1.getAll();
        Room[] fullRoomsCheck = new Room[api1.getAll().length];
        int count = 0;

        for (Room el1 : a1) {
            Room[] a2 = api2.findRooms(el1.getPrice(), el1.getPerson(), el1.getCityName(), el1.getHotelName());
            for (Room el2 : a2) {
                if (el2 != null && el1.getPerson() == el2.getPerson() &&
                        el1.getHotelName() == el2.getHotelName() &&
                        el1.getCityName() == el2.getCityName() &&
                        el1.getPrice() == el2.getPrice()) {
                    fullRoomsCheck[count] = el1;
                    count++;
                    //countWithoutNull++;
                }
            }
        }
        return fullRoomsCheck;
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

//    public static Room[] deleteNull(Room[] firstArray, int countWithoutNull) {
//
//        Room[] arrayWithoutNull = new Room[countWithoutNull];
//        int count1 = 0; // Счетчик результирующего массива без нал ячеек
//        for (Room el : firstArray) {
//            if (el != null) {
//                arrayWithoutNull[count1] = el;
//                count1++;
//            }
//        }
//        return arrayWithoutNull;
//    }
}