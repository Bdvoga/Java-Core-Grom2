package lesson35.demo;

import lesson35.controller.HotelController;
import lesson35.controller.UserController;
import lesson35.model.Hotel;
import lesson35.repository.HotelRepository;
import lesson35.repository.UserRepository;

import java.util.ArrayList;

public class DemoHotel {

    public static void main(String[] args) throws Exception {
        HotelController hotelController = new HotelController();
        UserController userController = new UserController();

        userController.login("Adriano", "password");

        //findHotelByName
        System.out.println(hotelController.findHotelByName("Zapad"));

        //findHotelByCity
        System.out.println(hotelController.findHotelByCity("Kyiv"));

        //Admin - addHotel
        Hotel hotel = new Hotel(0L, "Albatros", "Ukraine", "Dnepr", "Street One");
        System.out.println(hotelController.addHotel(hotel));

        //Admin - deleteHotel
        hotelController.deleteHotel(110);


        userController.logout();

    }
}
