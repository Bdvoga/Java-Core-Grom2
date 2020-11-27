package lesson35.repository;

import lesson35.model.*;

import java.io.*;
import java.util.ArrayList;

public class RoomRepository extends GeneralRepositoryAbstract {
    GeneralRepository generalRepository = new GeneralRepository();
    HotelRepository hotelRepository = new HotelRepository();

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        ArrayList<Room> rooms = writeToList("E:/Gromcode/Java Core/DB/RoomDb.txt");
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
        ArrayList<Room> rooms = writeToList(path);
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
        generalRepository.delete(writeToList(path), roomId, path);
    }

    @Override
    public ArrayList<Room> writeToList(String path) throws Exception {
        ArrayList<Room> rooms = new ArrayList<>();
        int count = 0; //Счетчик строк файла БД
        try {
            for (String[] el : readFile(path)) {
                Hotel hotel = generalRepository.findById(hotelRepository.writeToList("E:/Gromcode/Java Core/DB/HotelDb.txt"), Long.parseLong(el[6]));
                Room room = new Room(Long.parseLong(el[0]), Integer.parseInt(el[1]),
                        Double.parseDouble(el[2]), Boolean.valueOf(el[3]),
                        Boolean.valueOf(el[4]), generalRepository.transferDateFromFile(el[5]), hotel);
                rooms.add(room);
                count++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Неправильный формат данных в файле " + path + " в строке " + count);
        } catch (NumberFormatException e) {
            throw new Exception("Неправильный формат id в файле " + path + " в строке " + count);
        }

        return rooms;
    }
}
