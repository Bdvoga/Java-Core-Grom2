package lesson19.exercise2;

public class Controller {
    public static void put(Storage storage, File file) throws Exception {

        int count = ifFreeCell(storage, file); // Есть ли свободные ячейки
        ifHaveFormat(storage, file); // Поддерживает ли хранилище формат файла
        ifFreeSpace(storage, file); // Достаточно ли свободного места
        ifId(storage, file); // Проверка на дубль id

        // Сохраняем файл в хранилище
        storage.getFiles()[count] = file;
        System.out.println("put finished");
    }

    public static void delete(Storage storage, File file) throws Exception {
        boolean flag = false;
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].equals(file)) {
                storage.getFiles()[i] = null;
                System.out.println("Файл id=" + file.getId() + " был удален из хранилища " + storage.getId());
                flag = true;
                break;
            }
        }

        if (!flag) {
            throw new Exception("В хранилище " + storage.getId() +
                    " не найден файл " + file.getId());
        }
        System.out.println("delete finished");
    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        // Получаем данные переносимого файла
        int countFrom = 0;
        //File fileForTransfer = new File(0, "", "", 0);
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
        // Хватит ли свободных ячеек для переноса
        // 1. Есть ли свободные ячейки в хранилище + колличество + запоминаем номер таких ячеек
        int countFreeSpaceTo = 0; // кол-во свободных ячеек приемника
        int[] numberOfSpaceTo = new int[storageTo.getFiles().length]; // массив свободных адресов приемника
        for (int i = 0; i < storageTo.getFiles().length; i++) {
            if (storageTo.getFiles()[i] == null) {
                numberOfSpaceTo[countFreeSpaceTo] = i;
                countFreeSpaceTo++;
            }
        }

        // 2. Сколько файлов переносим + адреса переносимых файлов
        int countFilesFrom = 0; // кол-во файлов для передачи
        int[] numberOfFilesFrom = new int[storageFrom.getFiles().length]; // массив адресов файлов для передачи
        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            if (storageFrom.getFiles()[i] != null) {
                numberOfFilesFrom[countFilesFrom] = i;
                countFilesFrom++;
            }
        }
        if (countFilesFrom > countFreeSpaceTo) {
            throw new Exception("В хранилище id=" + storageTo.getId() + " недосточно свободных ячеек");
        }

        // Проверяем поддерживаемые форматы
        //boolean flag = false;
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

        //Проверка на уникальность id
        boolean flag = true;
        long id1 = 0, id2 = 0;
        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            for (int j = 0; j < storageTo.getFiles().length; j++) {
                if (storageFrom.getFiles()[i] != null && storageTo.getFiles()[j] != null &&
                        storageFrom.getFiles()[i].getId() == storageTo.getFiles()[j].getId()) {
                    flag = false;
                    id1 = storageFrom.getFiles()[i].getId();
                    id2 = storageTo.getFiles()[j].getId();
                }
            }
        }

        if (!flag) {
            throw new Exception("Совпадют id=" + id1 + " из хранилища id=" + storageFrom.getId() +
                    " и id=" + id2 + " из хранилища id=" + storageTo.getId());
        }

        // Переносим файлы
        for (int i = 0; i < countFilesFrom; i++) { // Проходим по массиву адресов переносимых файлов
            storageTo.getFiles()[numberOfSpaceTo[i]] = storageFrom.getFiles()[numberOfFilesFrom[i]];
            storageFrom.getFiles()[numberOfFilesFrom[i]] = null;
        }
    }

    private static int ifFreeCell(Storage storage, File file) throws Exception {
        // Есть ли свободные ячейки в хранилище + запоминаем номер такой ячейки
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                flag = true;
                count = i;
                break;
            }
        }
        if (!flag) {
            throw new Exception("В хранилище " + storage.getId() +
                    " нет свободных ячеек для файла " + file.getId());
        }
        return count;
    }

    public static void ifHaveFormat(Storage storage, File file) throws Exception {
        // Проверка формата файла
        boolean flag = false;
        for (String el : storage.getFormatSupported()) {
            if (file.getFormat().equals(el)) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new Exception("Неподдерживаемый формат файла " + file.getId() +
                    " для хранилища " + storage.getId());
        }
    }

    public static void ifFreeSpace(Storage storage, File file) throws Exception {
        // Проверка свободного места в хранилище
        long size = 0;
        for (File el : storage.getFiles()) { // Занято в хранилище
            if (el != null)
                size += el.getSize();
        }
        if (storage.getStorageSize() - size < file.getSize()) {
            throw new Exception("Недостаточно свободного места для файла " + file.getId() +
                    " для хранилища " + storage.getId());
        }
    }

    public static void ifId(Storage storage, File file) throws Exception {
        // Проверка уникальности ид
        for (File el : storage.getFiles()) {
            if (el != null && file.getId() == el.getId()) {
                throw new Exception("В хранилище " + storage.getId() + " есть файл с id " + file.getId());
            }
        }
    }
}