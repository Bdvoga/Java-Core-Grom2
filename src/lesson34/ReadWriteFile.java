package lesson34;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {

    public static void main(String[] args) throws InterruptedException, IOException {
        readFile("d:/test.txt");
        writeFile("d:/test1.txt");
    }

    private static void readFile(String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File doesn't exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " filed");
        }
    }

    private static void writeFile(String path) throws IOException {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append("\n"); //перевод строки
            bufferedWriter.append("PPPPPPPPP");
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }
}
