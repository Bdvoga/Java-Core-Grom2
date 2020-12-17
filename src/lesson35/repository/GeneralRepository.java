package lesson35.repository;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public abstract class GeneralRepository <T extends IdEntity, I> {

    public abstract <T> T getMappedObject(String[] object) throws Exception;

    // Запись в файл БД
    public <K> void writeListToFileBd(ArrayList<K> arrayList, String path) throws Exception {
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
    public void delete1(ArrayList<T> arrayList, long id, String path) throws Exception {
        arrayList.remove(findById(arrayList, id)); //Удаляем сущность из списка
        writeListToFileBd(arrayList, path);
    }

    public void delete(long id, String path) throws Exception {
        ArrayList<T> arrayList = getAllObjects(path); //считываем файл БД в список

//        for (T el : arrayList) {
//            if (el != null) {
//                System.out.println(el.toString());
//            } else {
//                System.out.println("null");
//            }
//
//        }

        arrayList.remove(findById(arrayList, id)); //удаляем объкт по id

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

    public <T> ArrayList<T> getAllObjects(String path) throws Exception {
        ArrayList<String[]> objects = readFromFile(path);
        if (objects.size() == 0) {
            return new ArrayList<>();
        }
        ArrayList<T> mappedObjects = new ArrayList<>();
        for (String[] object : objects) {
            mappedObjects.add(getMappedObject(object));
        }

        return mappedObjects;
    }

    //чтение данных из файла БД.тхт и запись в массив стрингов
    public ArrayList<String[]> readFromFile(String path) throws Exception {
        ArrayList<String[]> arrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] strings = line.split(",");
                arrayList.add(strings);
            }
        } catch (FileNotFoundException e) {
            throw new Exception("File doesn't exist");
        } catch (IOException e) {
            throw new IOException("Reading from file " + path + " filed");
        }

        return arrayList;
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
