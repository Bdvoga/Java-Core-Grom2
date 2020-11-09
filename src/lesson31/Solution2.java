package lesson31;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {

    public static Map<Character, Integer> countSymbols(String text) {
        Map<Character, Integer> res = new HashMap<>();

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                res.put(ch, res.get(ch) == null ? 1 : res.get(ch) + 1);
            }
        }

        return res;
    }

    public static HashMap<String, Integer> words(String text) {
        HashMap<String, Integer> res = new HashMap<>();
        String[] words = text.split(" ");

        for (String word : words) {
            if (word.length() > 2 && validateWord(word)) {
                res.put(word, res.get(word) == null ? 1 : res.get(word) + 1);
            }
        }

        return res;
    }

    private static boolean validateWord(String word) {
        char[] chars = word.toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }
}
