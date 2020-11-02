package lesson34.ex2;

import java.io.File;
import java.io.FileNotFoundException;

public class Solution {

    public static void transferFileContent(String fileFromPath, String fileToPath) {
        // проверить наличие файлов - вынесли в отдельный метод validate()
        // проверить права доступа - вынесли в отдельный метод validate()
        // считать контент
        // записать контент
        // очиситить файл Фром

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
            throw new Exception("File " + fileTo + "doesn't have permission to read");
        }
    }

}
