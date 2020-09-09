package lesson17.ex3;

public class Solution {
    public static void main(String[] args) {
        String str1 = "aaa bb bb bb aaa c";
        String str2 = "aaa bb bb aaa c";
        String str3 = "";
        String str4 = "   ";
        System.out.println(mostCountedWord(str1));
        System.out.println(mostCountedWord(str2));
        System.out.println(mostCountedWord(str3));
        System.out.println(mostCountedWord(str4));


    }

    public static String mostCountedWord(String input) {
        String[] words = input.split(" ");
        if (words.length == 0 || input == "")
            return null;

        int index = 0;
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                }
            }
            if (count > maxCount) {
                index = i;
                maxCount = count;
                count = 0;
            }
        }

        return words[index];
    }

}
