package lesson35.repository;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class GeneralRepository <T extends IdEntity> {

    // Запись в файл БД
    public <K> void writeListToFileBd(ArrayList<K> arrayList, String path) throws Exception {

        ArrayList<K> arrayList1 = ???

        int count = arrayList.size() - 1;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
            for (K k : arrayList) {
                String str = k.toString();
                bw.append(str);
                if (count != 0) {
                    bw.append("\n");
                }
                count--;
            }
        } catch (IOException e) {
            throw new IOException("Обшибка записи в файл " + path);
        }
    }

    // Удаление из базы по id
    public void delete(ArrayList<T> arrayList, long id, String path) throws Exception {
        arrayList.remove(findById(arrayList, id)); //Удаляем сущность из списка
        writeListToFileBd(arrayList, path);
    }

    //метод поиска по id любой сущности
    public T findById(ArrayList<T> arrayList, long id) {
        for (T el : arrayList) {
            if (el.getId() == id) {
                return el;
            }
        }

        return null;
    }

    //Генерация id нового объекта
    public long generationId(ArrayList<T> arrayList) {
        //создаем массив id
        long[] arrayId = new long[arrayList.size()];
        Random random = new Random();
        long newId;

        while (true) {
            newId = random.nextInt(10000 + 1);
            for (long el : arrayId) {
                if(el == newId) {
                    break;
                }
            }
            return newId;
        }
        //return 0;
    }

    public Date transferDateFromFile(String dateString) throws Exception {
        try {
            return new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
        } catch (ParseException e) {
            throw new Exception("Ошибка преобразования даты");
        }

    }

    //Генерация id нового объекта 2
//    public <T extends IdEntity> long generationId2(ArrayList<T> arrayList) {
//        //находим макс значение id
//        int index = 0;
//        long max = arrayList.get(0).getId();
//        for (T el : arrayList) {
//            if (arrayList.get(index).getId() > max) {
//                max = arrayList.get(index).getId();
//            }
//            index++;
//        }
//
//        return max + 1;
//    }
}
