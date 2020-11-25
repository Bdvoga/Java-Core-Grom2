package lesson35.service;

import lesson35.model.Hotel;
import lesson35.model.Session;
import lesson35.repository.HotelRepository;

import java.util.ArrayList;

public class HotelService {
    HotelRepository hotelRepository = new HotelRepository();
    GeneralService generalService = new GeneralService();

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        //залогинен ли юзер
        generalService.verification();

        return hotelRepository.findHotelByName(name);
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        //залогинен ли юзер
        generalService.verification();

        return hotelRepository.findHotelByCity(city);
    }

    public Hotel addHotel(Hotel hotel) throws Exception {
        //залогинен, Админ
        //все ли поля заполнены
        generalService.verificationAdmin();
        if (hotel.getName() != null && hotel.getCountry() != null && hotel.getCity() != null && hotel.getStreet() != null) {
            return hotelRepository.addHotel(hotel);
        } else {
            throw new Exception("Ошибка! Не все поля заполнены!");
        }
    }

    public void deleteHotel(long hotelId) throws Exception {
        generalService.verificationAdmin();
        hotelRepository.deleteHotel(hotelId);
    }


}
