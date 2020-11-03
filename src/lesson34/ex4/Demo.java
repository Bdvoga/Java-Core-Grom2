package lesson34.ex4;

public class Demo {

    public static void main(String[] args) throws Exception {

        Solution.copyFileContent("D:/fileFrom.txt", "D:/fileTo.txt");

        Solution.copyFileContentApacheIO("D:/fileFrom.txt", "D:/fileTo1.txt");
    }

}
