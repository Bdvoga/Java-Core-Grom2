package lesson34.ex4;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;

public class Solution {

    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);
        try {
            Files.copy(fileFrom.toPath(), fileTo.toPath());
        } catch (FileAlreadyExistsException e) {
            System.err.println("File " + fileToPath + " already exist");
        }
    }

    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws IOException {

        FileUtils.copyFile(new File(fileFromPath), new File(fileToPath));
    }
}
