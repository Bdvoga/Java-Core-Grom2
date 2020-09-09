package lesson17;

public class Solution1 {
    public static void main(String[] args) {

        System.out.println(countWords("Hello wor#ld one hel5p ttt     "));
        System.out.println(countWords(" "));
        System.out.println(countWords(""));

    }

    public static int countWords (String input) {
        if (input.length() == 0)
            return 0;

        String[] words = input.split(" ");
        int count = 0;

        for (String word : words) {
            boolean flag = true;
            char[] chars = word.toCharArray();
            for (char ch : chars) {
                if ((char) ch >= 32 && (char) ch <=64) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}
