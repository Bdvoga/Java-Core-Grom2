package lesson19.exercise2;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        try {
            File file1 = new File(1, "file1", "txt", 15);
            File file2 = new File(2, "file2", "png", 10);
            File file3 = new File(3, "file3", "txt", 20);
            File file4 = new File(4, "file4", "mkv", 22);
            File file5 = new File(5, "file5", "mkv", 30);
            File file6 = new File(6, "file6", "mkv", 10);
            File file7 = new File(7, "file7", "png", 30);
            File file8 = new File(8, "file8", "png", 5);


            File[] files1 = {file1, file2, null, file3, null, null, null};
            File[] files2 = {file4, file5, file6, null};

            String[] formatSupported1 = {"txt", "png"};
            String[] formatSupported2 = {"mkv", "mp3", "txt"};

            Storage storage1 = new Storage(1, files1, formatSupported1, "USA", 250);
            Storage storage2 = new Storage(2, files2, formatSupported2, "USA", 600);

            File[] files3 = {file1, file2, null, file3, null, null, null, null};
            File[] files4 = {file4, file5, file6, null, file7};
            String[] formatSupported3 = {"txt", "mkv", "mp3"};
            String[] formatSupported4 = {"mkv", "mp3", "txt"};
            Storage storage3 = new Storage(3, files3, formatSupported3, "USA", 250);
            Storage storage4 = new Storage(4, files4, formatSupported4, "USA", 600);

            // Проверяем метод put
            Controller.put(storage1, file7);
            for (File el : storage1.getFiles()) {
                if (el != null)
                    System.out.println(el.getId() + " " + el.getName() + " " + el.getFormat() + " " + el.getSize());
            }
            System.out.println();

            // Проверяем метод delete
            Controller.delete(storage2, file6);
            for (File el : storage2.getFiles()) {
                if (el != null)
                    System.out.println(el.getId() + " " + el.getName() + " " + el.getFormat() + " " + el.getSize());
            }
            System.out.println();

            // Проверяем метод transferFile
            Controller.transferFile(storage1, storage2, 1);
            for (File el : storage1.getFiles()) {
                if (el != null)
                    System.out.println(el.getId() + " " + el.getName() + " " + el.getFormat() + " " + el.getSize());
            }
            System.out.println();
            for (File el : storage2.getFiles()) {
                if (el != null)
                    System.out.println(el.getId() + " " + el.getName() + " " + el.getFormat() + " " + el.getSize());
            }
            System.out.println();

            // Проверяем transferAll
            Controller.transferAll(storage4, storage3);
            for (File el : storage3.getFiles()) {
                if (el != null)
                    System.out.println(el.getId() + " " + el.getName() + " " + el.getFormat() + " " + el.getSize());
            }
            System.out.println();
            for (File el : storage4.getFiles()) {
                if (el != null)
                    System.out.println(el.getId() + " " + el.getName() + " " + el.getFormat() + " " + el.getSize());
            }
            System.out.println();

        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
