package lesson33.ex0;

import org.apache.commons.io.IOUtils;
import java.io.*;

public class ReadFile {

    public static void main(String[] args) throws InterruptedException {
        readFile("d:/test.txt");
        writeFile("d:/test1.txt");
    }

    private static void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist");
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
        }
    }

    private static void writeFile(String path) throws InterruptedException {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        try {

            //Thread.sleep(5000);
            writer = new FileWriter(path, true); //работа в режиме добавления, а не перезаписи файла
            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.append("\n"); //перевод строки
            bufferedWriter.append("PPPPPPPPP");
        } catch (IOException e) {
            System.err.println("Can't write to file");
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }



    }
}
