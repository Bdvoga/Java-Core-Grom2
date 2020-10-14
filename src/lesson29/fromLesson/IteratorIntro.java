package lesson29.fromLesson;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class IteratorIntro {
    public static void main(String[] args) {
        Set<File> files = new HashSet<>();
        File file1 = new File("pict.txt", 100);
        File file2 = new File("home.txt", 178);
        File file3 = new File("home333.txt", 178);
        files.add(file1);
        files.add(file2);
        files.add(file3);

        Iterator<File> fileIterator = files.iterator(); // не используется сейчас
        while (fileIterator.hasNext()) {
            System.out.println(fileIterator.next().getFileName());
        }

        for (File file : files) { // лучше ипользовать форич
            System.out.println(file.getFileName());
        }

        Set<File> files1 = new LinkedHashSet<>();

    }
}
