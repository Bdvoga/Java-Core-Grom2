package lesson33.ex2;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class Solution {

    public static void writeToFileFromConsole(String path) {
        // если файл не существует
        try {
            FileReader fileReader = new FileReader(path);
            IOUtils.closeQuietly(fileReader);
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
            return;
        }

        System.out.print("Enter file content to write in the file: ");

        InputStreamReader reader = null;
        BufferedReader br = null;
        FileWriter writer = null;
        BufferedWriter bw = null;
        try {
            writer = new FileWriter(path, true); //работа в режиме добавления, а не перезаписи файла
            bw = new BufferedWriter(writer);

            while (true) {
                reader = new InputStreamReader(System.in);
                br = new BufferedReader(reader);
                String line = br.readLine();
                if (line.equals("wr")) {
                    return;
                }

                bw.append("\n"); //перевод строки
                bw.append(line);
            }
        } catch (IOException e) {
            System.err.println("Can't write to file with path " + path);
        } finally {
            System.out.println("end of program");
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(bw);
            IOUtils.closeQuietly(writer);
        }
    }
}
