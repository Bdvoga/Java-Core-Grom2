package lesson35.repository;

import lesson35.model.*;

import java.io.*;
import java.util.ArrayList;

public class RoomRepository extends RepositoryAbstract {
    GeneralRepository generalRepository = new GeneralRepository();
    HotelRepository hotelRepository = new HotelRepository();

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        ArrayList<Room> rooms = getAllObjects("E:/Gromcode/Java Core/DB/RoomDb.txt");
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
        ArrayList<Room> rooms = getAllObjects(path);
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
        generalRepository.delete(getAllObjects(path), roomId, path);
    }

    @Override
    public Room getMappedObject(String[] object) throws Exception {
        try {
            Hotel hotel = (Hotel) generalRepository.findById(getAllObjects("E:/Gromcode/Java Core/DB/HotelDb.txt"), Long.parseLong(object[6]));
            return new Room(Long.parseLong(object[0]), Integer.parseInt(object[1]),
                    Double.parseDouble(object[2]), Boolean.valueOf(object[3]),
                    Boolean.valueOf(object[4]), generalRepository.transferDateFromFile(object[5]), hotel);

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Exception("Неправильный формат данных в файле E:/Gromcode/Java Core/DB/RoomDb.txt");
        } catch (NumberFormatException e) {
            throw new Exception("Неправильный формат id в файле E:/Gromcode/Java Core/DB/RoomDb.txt");
        }
    }

//    public ArrayList<Room> mapObject(String path) throws Exception {
//        ArrayList<Room> rooms = new ArrayList<>();
//        int count = 0; //Счетчик строк файла БД
//        ArrayList<String[]> arrayList = readFile(path);
//        try {
//            for (String[] el : arrayList) {
//                Hotel hotel = (Hotel) generalRepository.findById(hotelRepository.writeToList("E:/Gromcode/Java Core/DB/HotelDb.txt"), Long.parseLong(el[6]));
//                Room room = new Room(Long.parseLong(el[0]), Integer.parseInt(el[1]),
//                        Double.parseDouble(el[2]), Boolean.valueOf(el[3]),
//                        Boolean.valueOf(el[4]), generalRepository.transferDateFromFile(el[5]), hotel);
//                rooms.add(room);
//                count++;
//            }
//        } catch (ArrayIndexOutOfBoundsException e) {
//            throw new Exception("Неправильный формат данных в файле " + path + " в строке " + count);
//        } catch (NumberFormatException e) {
//            throw new Exception("Неправильный формат id в файле " + path + " в строке " + count);
//        }
//
//        return rooms;
//    }
}
