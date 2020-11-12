package lesson34.ex2;

import java.io.*;

public class Solution {

    public static void transferFileContent(String fileFromPath, String fileToPath) throws Exception {
        // проверить наличие файлов - вынесли в отдельный метод validate()
        // проверить права доступа - вынесли в отдельный метод validate()
        // считать контент
        // записать контент
        // очиситить файл Фром

        validate(fileFromPath, fileToPath);
        writeToFile(fileToPath, fileFromPath, readFromFiles(fileFromPath));
    }

    private static void deleteFromFile(String fileFromPath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileFromPath, false))) {
            bufferedWriter.append("");
        } catch (IOException e) {
            System.err.println("Can't delete from file " + fileFromPath);
        }
    }

    private static StringBuffer readFromFiles(String path) throws Exception {
        StringBuffer res = new StringBuffer(); // в эту переменную считываем содерж файла фром
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            if (res.length() != 0) {
                res.replace(res.length() - 1, res.length(), ""); //Удаляем последний перевод строки
            }
        } catch (IOException e) {
            throw new IOException ("Reading from file " + path + " filed");
        }

        return res;
    }

    private static void writeToFile(String pathTo, String pathFrom, StringBuffer contentToWrite) {
        if (contentToWrite.length() != 0) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathTo, true))) {
                bw.append("\n");
                bw.append(contentToWrite);

                deleteFromFile(pathFrom);
            } catch (IOException e) {
                System.err.println("Can't write to file " + pathTo);
            }
        }
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " doesn't exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " doesn't exist");
        }

        if (!fileFrom.canRead()) { // имеем ли права на чтение файла
            throw new Exception("File " + fileFrom + "doesn't have permission to read");
        }

        if (!fileTo.canWrite()) { // имеем ли права на чтение файла
            throw new Exception("File " + fileTo + "doesn't have permission to write");
        }
    }
}
