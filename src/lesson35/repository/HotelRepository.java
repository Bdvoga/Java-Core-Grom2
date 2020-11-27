package lesson35.repository;

import lesson35.model.Hotel;

import java.io.*;
import java.util.ArrayList;

public class HotelRepository extends GeneralRepositoryAbstract {
    GeneralRepository generalRepository = new GeneralRepository();

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        String path = "E:/Gromcode/Java Core/DB/HotelDb.txt";
        ArrayList<Hotel> hotels = writeToList(path);
        ArrayList<Hotel> foundHotels = new ArrayList<>();

        for (Hotel el : hotels) {
            if (el.getName().equals(name)) {
                //формируем массив отелей
                foundHotels.add(el);
            }
        }

        return foundHotels;
    }

    public ArrayList<Hotel> findHotelByCity(String city) throws Exception {
        ArrayList<Hotel> hotels = writeToList("E:/Gromcode/Java Core/DB/HotelDb.txt");
        ArrayList<Hotel> foundHotels = new ArrayList<>();

        for (Hotel el : hotels) {
            if (el.getCity().equals(city)) {
                foundHotels.add(el);
            }
        }

        return foundHotels;
    }

    public Hotel addHotel(Hotel hotel) throws Exception {
        String path = "E:/Gromcode/Java Core/DB/HotelDb.txt";
        ArrayList<Hotel> hotels = writeToList(path);
        long id = generalRepository.generationId(hotels);
        hotel.setId(id);
        String str = hotel.toString();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.append("\n");
            bw.append(str);
            System.out.println("Отель " + hotel.getName() + " добавлен в базу");
            return hotel;
        } catch (IOException e) {
            throw new IOException("Обшибка записи d файл " + path);
        }
    }

    public void deleteHotel(long hotelId) throws Exception {
        String path = "E:/Gromcode/Java Core/DB/HotelDb.txt";
        generalRepository.delete(writeToList(path),hotelId,path);
    }

    @Override
    public ArrayList<Hotel> writeToList(String path) throws Exception {
        ArrayList<Hotel> hotels = new ArrayList<>();
        int count = 0;
        try {
            for (String[] el : readFile(path)) {
                Hotel hotel = new Hotel(Long.parseLong(el[0]), el[1], el[2], el[3], el[4]);
                hotels.add(hotel);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Неправильный формат данных в файле " + path + " в строке " + count);
        } catch (NumberFormatException e) {
            throw new Exception("Неправильный формат id в файле " + path + " в строке " + count);
        }

        return hotels;
    }
}
