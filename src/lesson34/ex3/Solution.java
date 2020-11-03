package lesson34.ex3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        //есть ли файлы + права доступа - validator
        //читаем файл и ищем предложение по условию
        // переносим
        // перезаписать файл Фром без перенесенных предложений

        validate(fileFromPath, fileToPath);
        writeToFile(fileToPath, readSentencesForTransfer(fileFromPath, word), true);
        deleteSentencesFromFile(fileFromPath, word);
    }

    private static void deleteSentencesFromFile(String path, String word) {
        StringBuilder file = readFromFile(path);

        String[] sentences = readFromFile(path).toString().split("\\.");

        StringBuilder res = new StringBuilder();
        for (String str : sentences) {
            if (str.length() > 10 && str.contains(word)) {

            }
        }

        if (res.length() != 0) {
            res.replace(res.length() - 1, res.length(), ""); //Удаляем последний перевод строки
        }

        writeToFile(path, res, false);

    }

    private static StringBuilder readFromFile(String path) {
        StringBuilder res = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " filed");
        }

        if (res.length() != 0) {
            res.replace(res.length() - 1, res.length(), ""); //Удаляем последний перевод строки
        }

        return res;
    }

    private static StringBuilder readSentencesForTransfer(String path, String word) {

        String[] sentences = readFromFile(path).toString().split("\\.");

        StringBuilder res = new StringBuilder();
        for (String str : sentences) {
            if (str.length() > 10 && str.contains(word)) {
                res.append(str);
                res.append("\n");
            }
        }

        if (res.length() != 0) {
            res.replace(res.length() - 1, res.length(), ""); //Удаляем последний перевод строки
        }

        return res;
    }

    private static void writeToFile(String path, StringBuilder contentToWrite, boolean append) {
        if (contentToWrite != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, append))) {
                bw.append("\n");
                bw.append(contentToWrite);
            } catch (IOException e) {
                System.err.println("Can't write to file " + path);
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

//    private static void deleteSentencesFromFile(String path, String word) {
//        //StringBuilder file = readerFromFile(path);
//
//        String[] sentences = readFromFile(path).toString().split("\\.");
//
//        StringBuilder res = new StringBuilder();
//        for (String str : sentences) {
//            if (!(str.length() > 10 && str.contains(word))) {
//                res.append(str);
//                res.append("\n");
//            }
//        }
//
//        if (res.length() != 0) {
//            res.replace(res.length() - 1, res.length(), ""); //Удаляем последний перевод строки
//        }
//
//        writeToFile(path, res, false);
//
//    }
}
