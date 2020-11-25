package lesson35.repository;

import lesson35.model.Hotel;

import java.io.*;
import java.util.ArrayList;

public class HotelRepository {
    GeneralRepository generalRepository = new GeneralRepository();

    public ArrayList<Hotel> findHotelByName(String name) throws Exception {
        String path = "E:/Gromcode/Java Core/DB/HotelDb.txt";
        ArrayList<Hotel> hotels = readFileHotel(path);
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
        ArrayList<Hotel> hotels = readFileHotel("E:/Gromcode/Java Core/DB/HotelDb.txt");
        ArrayList<Hotel> foundHotels = new ArrayList<>();

        for (Hotel el : hotels) {
            if (el.getCity().equals(city)) {
                foundHotels.add(el);
            }
        }

        return foundHotels;
    }

    public ArrayList<Hotel> readFileHotel(String path) throws Exception { //Hotel
        ArrayList<Hotel> hotelArrayList = new ArrayList<>();
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                Hotel hotel = new Hotel(Long.parseLong(strings[0]), strings[1], strings[2], strings[3], strings[4]);
                hotelArrayList.add(hotel);
            }
        } catch (FileNotFoundException e) {
            throw new Exception("File doesn't exist");
        } catch (IOException e) {
            throw new IOException("Reading from file " + path + " filed");
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Неправильный формат данных в файле " + path + " в строке " + count);
        } catch (NumberFormatException e) {
            throw new Exception("Неправильный формат id в файле " + path + " в строке " + count);
        }

        return hotelArrayList;
    }

    public Hotel addHotel(Hotel hotel) throws Exception {
        String path = "E:/Gromcode/Java Core/DB/HotelDb.txt";
        ArrayList<Hotel> hotels = readFileHotel(path);
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
        generalRepository.delete(readFileHotel(path),hotelId,path);
    }
}
