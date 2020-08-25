package lesson11.biginterfaceexample;

public class FileReader implements Readable {

    @Override
    public void readFilesFromStorage(Storage storage) {
        // Создадим два метода, кот будут выполнять:
        //1. Найти файл макс размера
        //2. Вывести всю инфу о нем

        printFile(findMaxSizeFile(storage.getFiles()));

    }

    //1.
    private File findMaxSizeFile(File[] files) {
        File maxSizeFile = files[0];

        for (File file : files) {
            if (file != null && file.getSize() > maxSizeFile.getSize()) {
                maxSizeFile = file;
            }
        }

        return maxSizeFile;
    }

    //2.
    private void printFile(File file) {
        System.out.println("max file will be printed now...");
        System.out.println(file.getName());
        System.out.println(file.getExtension());
        System.out.println(file.getPath());
        System.out.println(file.getSize());
        System.out.println();
    }

}
