package lesson31;

import java.util.HashMap;

public class Solution {

    public static HashMap<Character, Integer> countSymbols(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = text.toCharArray();

        // буква - ключ, кол-во повторений - значение
        for (Character ch : chars) {
            if (!Character.isLetter(ch)) {
                continue;
            }

            checkChar(map, ch);
        }

        return map;
    }

    public static HashMap<String, Integer> words(String text) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] strings = text.split(" ");

        // Слово - ключ, кол-во повторений - значение
        for (String str : strings) { // Перебор слов
            if (str.length() <= 2 || !str.matches("[a-zA-Z]+")) {
                continue;
            }

            checkString(map, str);
        }

        return map;
    }

    private static void checkChar(HashMap<Character, Integer> map, Character ch) {
        if (map.get(ch) == null) {
            map.put(ch, 1);
        } else {
            int count = map.get(ch) + 1;
            map.put(ch, count);
        }
    }

    private static void checkString(HashMap<String, Integer> map, String str) {
        if (map.get(str) == null) {
            map.put(str, 1);
        } else {
            int count = map.get(str) + 1;
            map.put(str, count);
        }
    }
}
