package lesson35.repository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class GeneralRepository {

    // Удаление из базы по id
    public <T extends IdEntity> void delete(ArrayList<T> arrayList, long id, String path) throws Exception {
        arrayList.remove(findById(arrayList,id)); //Удаляем сущность из списка
        writeListToFileBd(arrayList, path);
    }

    // Запись в файл БД
    public <T> void writeListToFileBd(ArrayList<T> arrayList, String path) throws Exception {
        int count = arrayList.size() - 1;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
            for (T t : arrayList) {
                String str = t.toString();
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

    //метод поиска по id любой сущности
    public <T extends IdEntity> T findById(ArrayList<T> arrayList, long id) {
        for (T el : arrayList) {
            if (el.getId() == id) {
                return el;
            }
        }

        return null;
    }

    //Генерация id нового объекта
    public <T extends IdEntity> long generationId(ArrayList<T> arrayList) {
        //находим макс значение id
        int index = 0;
        long max = arrayList.get(0).getId();
        for (T el : arrayList) {
            if (arrayList.get(index).getId() > max) {
                max = arrayList.get(index).getId();
            }
            index++;
        }

        return max + 1;
    }

    public Date transferDateFromFile(String dateString) throws Exception {
        try {
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
            return date;
        } catch (ParseException e) {
            throw new Exception("Ошибка преобразования даты");
        }
    }
}
