package lesson17;

public class Solution2 {
    public static void main(String[] args) {
        String str1 = "aa bbb cccccc dd";
        String str2 = "    ";
        String str3 = "";
        String str4 = "aaaa";

        System.out.println(maxWord(str1));
        System.out.println(maxWord(str2));
        System.out.println(maxWord(str3));
        System.out.println(maxWord(str4));
        System.out.println();
        System.out.println(minWord(str1));
        System.out.println(minWord(str2));
        System.out.println(minWord(str3));
        System.out.println(minWord(str4));

    }

    public static String maxWord(String input) {
        String[] words = input.split(" ");
        if (words.length == 0) {
            return null;
        }

        int index = 0;
        int maxLength = words[0].toCharArray().length;
        for (int i = 1; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            if (chars.length > maxLength) {
                maxLength = chars.length;
                index = i;
            }
        }
        return words[index];
    }

    public static String minWord(String input) {
        String[] words = input.split(" ");
        if (words.length == 0) {
            return null;
        }

        int index = 0;
        int minLength = words[0].toCharArray().length;
        for (int i = 1; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            if (chars.length < minLength) {
                minLength = chars.length;
                index = i;
            }
        }
        return words[index];
    }
}
