package lesson33.ex1;

import java.io.FileNotFoundException;

public class Demo {

    public static void main(String[] args) {
        ReadWriteFile.readFile("d:/test.txt");
        ReadWriteFile.readFile("d:/test1.txt");
        ReadWriteFile.writeFile("d:/test2.txt", "777777");
    }
}
