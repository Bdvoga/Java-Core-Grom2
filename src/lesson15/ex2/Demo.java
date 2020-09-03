package lesson15.ex2;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Room room1 = new Room(1,25, 1, new Date(), "C1", "H1");
        Room room2 = new Room(2,15, 1, new Date(), "C1", "H1");
        Room room3 = new Room(3,15, 10, new Date(), "C1", "H1");
        Room room4 = new Room(4,200, 4, new Date(), "C1", "H1");
        Room room5 = new Room(5,4, 10, new Date(), "C1", "H1");

        Room[] rooms = {room1, room2, room3, room4, room5};

        Room[] rooms1 = {room1, room2, room5};
        Room[] rooms2 = {room2, room3, room4, room5};
        Room[] rooms3 = {};
//--------------------------------------------
        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        BookingComAPI bookingComAPI1 = new BookingComAPI(rooms3);
        //Что проверяем
        //1. Метод находит комнаты по условию +
        //2. нет комнтат под условие +
        //3. в базе нет никаких комнат
        System.out.println("bookingComAPI 1");
        for (Room el : bookingComAPI.findRooms(10, 10, "C1", "H1"))
            System.out.println(el.getId() + " " + el.getPrice());
        System.out.println("bookingComAPI 2");
        for (Room el : bookingComAPI.findRooms(1000, 10, "C1", "H1"))
            System.out.println(el.getId() + " " + el.getPrice());
        System.out.println("bookingComAPI 3");
        for (Room el : bookingComAPI1.findRooms(10, 10, "C1", "H1"))
            System.out.println(el.getId() + " " + el.getPrice());

        System.out.println();
//-------------------------------------------
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms1);
        TripAdvisorAPI tripAdvisorAPI1 = new TripAdvisorAPI(rooms2);
        //Что проверяем
        //1. Метод находит комнаты по условию +
        //2. нет комнтат под условие +
        //3. в базе нет никаких комнат
        System.out.println("tripAdvisorAPI 1");
        for (Room el : tripAdvisorAPI.findRooms(4, 9, "C1", "H1"))
            System.out.println(el.getId() + " " + el.getPrice());
        System.out.println("tripAdvisorAPI 2");
        for (Room el : tripAdvisorAPI.findRooms(200, 3, "C1", "H2"))
            System.out.println(el.getId() + " " + el.getPrice());
        System.out.println("tripAdvisorAPI 3");
        for (Room el : tripAdvisorAPI1.findRooms(200, 3, "C1", "H2"))
            System.out.println(el.getId() + " " + el.getPrice());

        System.out.println();
//---------------------------------------------
        GoogleAPI googleAPI = new GoogleAPI(rooms2);
        GoogleAPI googleAPI1 = new GoogleAPI(rooms2);
        //Что проверяем
        //1. Метод находит комнаты по условию +
        //2. нет комнтат под условие +
        //3. в базе нет никаких комнат
        System.out.println("googleAPI 1");
        for (Room el : googleAPI.findRooms(15, 1, "C1", "H1"))
            System.out.println(el.getId() + " " + el.getPrice());
        System.out.println("googleAPI 2");
        for (Room el : googleAPI.findRooms(14, 1, "C1", "H1"))
            System.out.println(el.getId() + " " + el.getPrice());
        System.out.println("googleAPI 3");
        for (Room el : googleAPI1.findRooms(14, 1, "C1", "H1"))
            System.out.println(el.getId() + " " + el.getPrice());

        System.out.println();
//-----------------------------
        //Controller
        API[] apis = {bookingComAPI, tripAdvisorAPI, googleAPI};

        Controller controller = new Controller(apis);

        //1. requestRooms
        //Что проверяем
        //1. Метод находит комнаты по условию +
        //2. нет комнтат под условие +
        //3. нет комнат в городе С2
        System.out.println("requestRooms 1");
        for (Room el : controller.requestRooms(5, 1, "C1", "H1"))
            System.out.println(el.getId() + " " + el.getPrice());
        System.out.println("requestRooms 2");
        for (Room el : controller.requestRooms(1000, 1, "C1", "H1"))
            System.out.println(el.getId() + " " + el.getPrice());
        System.out.println("requestRooms 3");
        for (Room el : controller.requestRooms(5, 1, "C2", "H1"))
            System.out.println(el.getId() + " " + el.getPrice());
        System.out.println();
//
        //2. check
        //Что проверяем
        //1. Метод находит комнаты по условию +
        System.out.println("check 1");
        for (Room el : controller.check(tripAdvisorAPI, googleAPI))
            System.out.println(el.getId());
        System.out.println();

        //3. cheapestRoom()
        //1. Метод находит комнаты по условию +
        System.out.println("cheapestRoom 1");
        System.out.println(controller.cheapestRoom().getId() + " " + controller.cheapestRoom().getPrice());

    }
}