package lesson19.exercise2;

public class Controller {

    public static void put(Storage storage, File file) throws Exception {
        int count = ifFreeCell(storage, file); // Есть ли свободные ячейки
        ifHaveFormat(storage, file); // Поддерживает ли хранилище формат файла
        ifFreeSpace(storage, file); // Достаточно ли свободного места
        ifDoubleId(storage, file); // Проверка на дубль id

        // Сохраняем файл в хранилище
        storage.getFiles()[count] = file;
        System.out.println("put finished");
    }

    public static void delete(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].equals(file)) {
                storage.getFiles()[i] = null;
                System.out.println("Файл id=" + file.getId() + " был удален из хранилища id=" + storage.getId());
                return;
            }
        }
        throw new Exception("В хранилище id=" + storage.getId() + " не найден файл id=" + file.getId());
    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        // Получаем данные переносимого файла
        int countFrom = 0;
        for (int i = 0; i < storageFrom.getFiles().length; i++) { // Размер переносимого файла
            if (storageFrom.getFiles()[i].getId() == id) {
                countFrom = i;
                break;
            }
        }

        // Записываем файл в storageTo
        put(storageTo, storageFrom.getFiles()[countFrom]);

        // Удаляем файл из хранилища From
        storageFrom.getFiles()[countFrom] = null;
        System.out.println("transfer finished");
    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        int[][] addr = ifAddressAll(storageFrom, storageTo); // Наличие свободных ячеек для переноса + кол-во переносимых файлов
        ifFormatAll(storageFrom, storageTo); // Поддерживаются ли форматы
        ifSpaceAll(storageFrom, storageTo);
        IfDoubleIdAll(storageFrom, storageTo);

        // Переносим файлы
        for (int i = 0; i < addr[0].length; i++) { // Проходим по массиву адресов переносимых файлов
            storageTo.getFiles()[addr[1][i]] = storageFrom.getFiles()[addr[0][i]];
            storageFrom.getFiles()[addr[0][i]] = null;
        }
    }

    // Блок методов проверок для методов put и transfer
    private static int ifFreeCell(Storage storage, File file) throws Exception {
        // Есть ли свободные ячейки в хранилище + запоминаем номер такой ячейки
        int count = 0;
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                count = i;
                return count;
            }
        }
        throw new Exception("В хранилище id=" + storage.getId() + " нет свободных ячеек для файла id=" + file.getId());
    }

    private static void ifHaveFormat(Storage storage, File file) throws Exception {
        // Проверка формата файла
        for (String el : storage.getFormatSupported()) {
            if (file.getFormat().equals(el)) {
                return;
            }
        }
        throw new Exception("Неподдерживаемый формат файла id=" + file.getId() + " для хранилища id=" + storage.getId());
    }

    private static void ifFreeSpace(Storage storage, File file) throws Exception {
        // Проверка свободного места в хранилище
        long size = 0;
        for (File el : storage.getFiles()) { // Занято в хранилище
            if (el != null)
                size += el.getSize();
        }
        if (storage.getStorageSize() - size < file.getSize()) {
            throw new Exception("Недостаточно свободного места для файла id=" + file.getId() +
                    " для хранилища id=" + storage.getId());
        }
    }

    private static void ifDoubleId(Storage storage, File file) throws Exception {
        // Проверка уникальности ид
        for (File el : storage.getFiles()) {
            if (el != null && file.getId() == el.getId()) {
                throw new Exception("В хранилище id=" + storage.getId() + " есть файл с id=" + file.getId());
            }
        }
    }

    // Блок методов проверок для метода transferAll
    private static int[][] ifAddressAll(Storage storageFrom, Storage storageTo) throws Exception {
        // Хватит ли свободных ячеек для переноса
        // 1. Есть ли свободные ячейки в хранилище + колличество + запоминаем номер таких ячеек
        int countFreeSpaceTo = 0; // кол-во свободных ячеек приемника
        int[] numberOfSpaceTo = new int[storageTo.getFiles().length];
        for (int i = 0; i < storageTo.getFiles().length; i++) {
            if (storageTo.getFiles()[i] == null) {
                numberOfSpaceTo[countFreeSpaceTo] = i; // массив свободных адресов приемника
                countFreeSpaceTo++;
            }
        }

        // 2. Сколько файлов переносим + адреса переносимых файлов
        int countFilesFrom = 0; // кол-во файлов для передачи
        int[] numberOfFilesFrom = new int[storageFrom.getFiles().length];
        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            if (storageFrom.getFiles()[i] != null) {
                numberOfFilesFrom[countFilesFrom] = i; // массив адресов файлов для передачи
                countFilesFrom++;
            }
        }
        if (countFilesFrom > countFreeSpaceTo) {
            throw new Exception("В хранилище id=" + storageTo.getId() + " недосточно свободных ячеек");
        }

        int[][] addresses = {numberOfFilesFrom, numberOfSpaceTo};
        return addresses;
    }

    private static void ifFormatAll(Storage storageFrom, Storage storageTo) throws Exception {
        // Проверяем поддерживаемые форматы
        int countFormat = 0;
        for (int i = 0; i < storageFrom.getFormatSupported().length; i++) {
            for (int j = 0; j < storageTo.getFormatSupported().length; j++) {
                if (storageFrom.getFormatSupported()[i].equals(storageTo.getFormatSupported()[j])) {
                    countFormat++;
                }
            }
        }
        if (countFormat < storageFrom.getFormatSupported().length) {
            throw new Exception("Неподдерживаемый формат файла для хранилища id=" + storageTo.getId());
        }
    }

    private static void ifSpaceAll(Storage storageFrom, Storage storageTo) throws Exception {
        // Проверка свободного места в хранилище To
        // 1. Общий размер файлов для переноса
        long sizeFrom = 0;
        for (File el : storageFrom.getFiles()) {
            if (el != null)
                sizeFrom += el.getSize();
        }
        // 2. Занятое место в приемнике
        long sizeTo = 0;
        for (File el : storageTo.getFiles()) { // Занято в хранилище
            if (el != null)
                sizeTo += el.getSize();
        }

        if (sizeFrom > (storageTo.getStorageSize() - sizeTo)) {
            throw new Exception("В хранилище id=" + storageTo.getId() + " недосточно свободного места");
        }
    }

    private static void IfDoubleIdAll(Storage storageFrom, Storage storageTo) throws Exception {
        //Проверка на уникальность id
        long id1 = 0, id2 = 0;
        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            for (int j = 0; j < storageTo.getFiles().length; j++) {
                if (storageFrom.getFiles()[i] != null && storageTo.getFiles()[j] != null &&
                        storageFrom.getFiles()[i].getId() == storageTo.getFiles()[j].getId()) {
                    id1 = storageFrom.getFiles()[i].getId();
                    id2 = storageTo.getFiles()[j].getId();
                    throw new Exception("Совпадют id=" + id1 + " из хранилища id=" + storageFrom.getId() +
                            " и id=" + id2 + " из хранилища id=" + storageTo.getId());
                }
            }
        }
    }

}