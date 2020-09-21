package lesson18.exercise1;

public class HandleError {

    public static void main(String[] args) {
        VideoStorage videoStorage = new VideoStorage();
        MusicStorage musicStorage = new MusicStorage();
        PictureStorage pictureStorage = new PictureStorage();

        String[] fileNames1 = {"test1", "test2", "test3", "test4", "test5", "test6"};
        String[] fileNames2 = {"test7", "test8", "test9", "test10", "test11"};
        String[] fileNames3 = {"test12", "test13", "test14"};

        videoStorage.setFiles(fileNames1);
        musicStorage.setFiles(fileNames2);
        pictureStorage.setFiles(fileNames3);

        System.out.println("Start printing name...");

        print5thName(videoStorage);
        print5thName(musicStorage);
        print5thName(pictureStorage);

        System.out.println("Done");
    }


    public static void print5thName(Storage storage) {
        String[] names = storage.getFiles();

        try {
            System.out.println("5th name is " + names[4]);
        } catch (Exception e) {
            System.out.println("5th name cannot be found...");
            //System.err.println(e.getMessage());
        }


    }
}
