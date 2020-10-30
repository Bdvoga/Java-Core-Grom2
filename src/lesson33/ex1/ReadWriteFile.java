package lesson33.ex1;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {

    public static void readFile(String path) {
        FileReader reader = null;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist");
            IOUtils.closeQuietly(reader);
            return;
        }

        BufferedReader br = new BufferedReader(reader);
        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " filed");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }

    public static void writeFile(String path, String content) {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        try {
            writer = new FileWriter(path, true); //работа в режиме добавления, а не перезаписи файла
            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.append("\n"); //перевод строки
            bufferedWriter.append(content);
        } catch (IOException e) {
            System.err.println("Can't write to file");
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }
    }
}
