package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.service.HotelService;

import java.util.ArrayList;
//    findHotelByName(String name) - поиск гостинницы по имени +
//    findHotelByCity(String city) - поиск гостинницы по городу +

// для ADMIN
//    addHotel(Hotel hotel) +
//    deleteHotel(long hotelId) +


public class HotelController {

    HotelService hotelService = new HotelService();

    public Hotel addHotel(Hotel hotel) throws Exception {
        return hotelService.addHotel(hotel);
    }

    public void deleteHotel(long hotelId) throws Exception {
        hotelService.deleteHotel(hotelId);
    }

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        return hotelService.findHotelByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        return hotelService.findHotelByCity(city);
    }
}
