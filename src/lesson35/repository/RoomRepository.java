package lesson35.repository;

import lesson35.model.*;

import java.io.*;
import java.util.ArrayList;

public class RoomRepository {
    GeneralRepository generalRepository = new GeneralRepository();
    HotelRepository hotelRepository = new HotelRepository();

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        ArrayList<Room> rooms = readFileRoom("E:/Gromcode/Java Core/DB/RoomDb.txt");
        ArrayList<Room> foundRooms = new ArrayList<>();
        for (Room el : rooms) {
            if (el.getNumberOfGuests().equals(filter.getNumberOfGuests()) && el.getPrice().equals(filter.getPrice()) &&
                    el.getBreakfastIncluded().equals(filter.getBreakfastIncluded()) && el.getPetsAllowed().equals(filter.getPetsAllowed() &&
                    el.getDateAvailableFrom().equals(filter.getDateAvailableFrom()) && el.getHotel().getCountry().equals(filter.getCountry()) &&
                    el.getHotel().getCity().equals(filter.getCity()))) {
                foundRooms.add(el);
            }
        }

        return foundRooms;
    }

    public Room addRoom(Room room) throws Exception {
        String path = "E:/Gromcode/Java Core/DB/RoomDb.txt";
        ArrayList<Room> rooms = readFileRoom(path);
        room.setId(generalRepository.generationId(rooms));
        String str = room.toString();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            bw.append("\n");
            bw.append(str);
            System.out.println("Комната " + room + " добавлена в базу");
            return room;
        } catch (IOException e) {
            throw new IOException("Reading from file " + path + " filed");
        }
    }

    public void deleteRoom(long roomId) throws Exception {
        String path = "E:/Gromcode/Java Core/DB/RoomDb.txt";
        generalRepository.delete(readFileRoom(path), roomId, path);
    }

    public ArrayList<Room> readFileRoom(String path) throws Exception { //Hotel
        ArrayList<Room> roomArrayList = new ArrayList<>();
        int count = 0; //Счетчик строк файла БД
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                Hotel hotel = generalRepository.findById(hotelRepository.readFileHotel("E:/Gromcode/Java Core/DB/HotelDb.txt"), Long.parseLong(strings[6]));
                Room room = new Room(Long.parseLong(strings[0]), Integer.parseInt(strings[1]),
                        Double.parseDouble(strings[2]), Boolean.valueOf(strings[3]),
                        Boolean.valueOf(strings[4]), generalRepository.transferDateFromFile(strings[5]), hotel);
                roomArrayList.add(room);
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

        return roomArrayList;
    }
}
