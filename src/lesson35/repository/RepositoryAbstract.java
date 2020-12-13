package lesson35.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class RepositoryAbstract {

    public abstract <T> T getMappedObject(String[] object) throws Exception;

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
}
