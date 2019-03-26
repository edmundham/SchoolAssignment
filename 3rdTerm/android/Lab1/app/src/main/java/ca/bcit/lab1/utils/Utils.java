package ca.bcit.lab1.utils;

public class Utils {
    public static String reverseString(final String text) {
        if (text == null || text == "") {
            return "";
        }

        String reverse = "";

        for(int i = text.length() - 1; i >= 0; i--) {
            reverse = reverse + text.charAt(i);
        }

        return reverse;
    }
}
