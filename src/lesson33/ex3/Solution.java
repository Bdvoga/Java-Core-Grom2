package lesson33.ex3;

import org.apache.commons.io.IOUtils;
import java.io.*;

public class Solution {

    public static void readFileByConsolePath() {
        System.out.print("Please, enter file path to read: ");
        InputStreamReader reader = null;
        BufferedReader br = null;

        try {
            reader = new InputStreamReader(System.in);
            br = new BufferedReader(reader);

            String path = br.readLine();

            readFile(path);
        } catch (IOException e) {
            System.err.println("I/O error");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }
    }

    public static void readFile(String path) {
        FileReader reader = null;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
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
            System.err.println("Can't read file by path " + path);
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }
}