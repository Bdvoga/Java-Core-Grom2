package lesson35.repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class GeneralRepositoryAbstract {

    public abstract <T> ArrayList<T> writeToList(String path) throws Exception;

    public ArrayList<String[]> readFile(String path) throws Exception {
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
}
