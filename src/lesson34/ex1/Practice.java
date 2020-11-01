package lesson34.ex1;

import java.io.*;

public class Practice {

    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        // проверить наличие файла - вынесли в отдельный метод validate()
        // проверить права доступа - вынесли в отдельный метод validate()
        // считать контент
        // записать контент

        validate(fileFromPath, fileToPath);

        writeToFile(fileToPath, readFromFiles(fileFromPath));
    }

    private static StringBuffer readFromFiles(String path) {
        StringBuffer res = new StringBuffer(); // в эту переменную считываем содерж файла фром
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), ""); //Удаляем последний перевод строки
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " filed");
        }

        return res;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can't write to file");
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

        if (!fileTo.canRead()) { // имеем ли права на чтение файла
            throw new Exception("File " + fileTo + "doesn't have permission to read");
        }
    }
}