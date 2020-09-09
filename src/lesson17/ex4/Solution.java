package lesson17.ex4;

public class Solution {
    public static void main(String[] args) {
        String address1 = "http://world.com";
        String address2 = "https://world1.org";
        String address3 = "http://+world.org";
        String address4 = "https://&world.org";
        String address5 = "http*://world.net";
        String address6 = "http://world.cam";

        System.out.println(validate(address1));
        System.out.println(validate(address2));
        System.out.println(validate(address3));
        System.out.println(validate(address4));
        System.out.println(validate(address5));
        System.out.println(validate(address6));

    }

    public static boolean validate(String address) {
        char[] chars = address.toCharArray();
        String substring = address.substring(address.length() - 4);
        boolean com = substring.equals(".com");
        boolean org = substring.equals(".org");
        boolean net = substring.equals(".net");

        if ((address.substring(0, 7).equals("http://")) && (com || org || net)) {
            for (int i = 7; i < address.length() - 4; i++) {
                if (!(((char) chars[i] >= 48 && (char) chars[i] <= 57) ||
                        ((char) chars[i] >= 65 && (char) chars[i] <= 90) ||
                        ((char) chars[i] >= 97 && (char) chars[i] <= 122))) {
                    return false;
                }
            }
            return true;
        }

        if ((address.substring(0, 8).equals("https://")) && (com || org || net)) {
            for (int i = 8; i < address.length() - 4; i++) {
                if (!(((char) chars[i] >= 48 && (char) chars[i] <= 57) ||
                        ((char) chars[i] >= 65 && (char) chars[i] <= 90) ||
                        ((char) chars[i] >= 97 && (char) chars[i] <= 122))) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}
