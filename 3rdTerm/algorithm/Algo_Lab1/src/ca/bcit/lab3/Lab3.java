package ca.bcit.lab3;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Lab3 {

    private static DecimalFormat decimalFormat = new DecimalFormat(".###");

    public static void main(String[] args) throws IOException {
        List<String> dictList = Lab3.readDictionary("Dict.txt");
        checkAnagram(1, dictList);
        checkAnagram(2, dictList);
        checkAnagram(3, dictList);
    }

    private static void checkAnagram(int techniqueNumber, List<String> dictList) {
        Map<String, Integer> dictMap = new HashMap<>();
        int max = 0;
        String mostAnagram = "";

        for (int i = 0; i < dictList.size(); i++) {
            dictMap.put(dictList.get(i), 0);
        }

        long beginFirst = System.currentTimeMillis();
        for (int i = 0; i < dictList.size(); i++) {
            for (int j = i + 1; j < dictList.size(); j++) {
                if (techniqueNumber == 1) {
                    if (Lab3.techniqueFirst(dictList.get(i), dictList.get(j))) {
                        dictMap.put(dictList.get(i), dictMap.get(dictList.get(i)) + 1);
                    }
                } else if (techniqueNumber == 2) {
                    if (Lab3.techniqueSecond(dictList.get(i), dictList.get(j))) {
                        dictMap.put(dictList.get(i), dictMap.get(dictList.get(i)) + 1);
                    }
                } else {
                    if (Lab3.techniqueThird(dictList.get(i), dictList.get(j))) {
                        dictMap.put(dictList.get(i), dictMap.get(dictList.get(i)) + 1);
                    }
                }
            }
        }
        long endFirst = System.currentTimeMillis();

        for (Map.Entry<String, Integer> entry : dictMap.entrySet()) {
            if (entry.getValue() >= 6) {
                max = entry.getValue();
                mostAnagram = entry.getKey();
            }
        }
        System.out.println("Technique #" + techniqueNumber + ": [" + mostAnagram + "] has " + max + " anagrams " + decimalFormat.format((endFirst - beginFirst) / 1000.0 ) + " secs");
    }

    private static List<String> readDictionary(String fileName) {
        List<String> dict = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(fileName))) {
            while (scan.hasNext()) {
                dict.add(scan.next());
            }
        } catch (Exception e) {
            System.out.printf("Caught Exception: %s%n", e.getMessage());
            e.printStackTrace();
        }
        return dict;
    }

    private static boolean techniqueFirst(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        first = first.toLowerCase();
        second = second.toLowerCase();

        StringBuilder stringBuilderSecond = new StringBuilder(second);
        int stringBuilderLength = stringBuilderSecond.length();

        for (int i = 0; i < first.length(); i++) {
            for (int j = 0; j < stringBuilderLength; j++) {
                if (first.charAt(i) == stringBuilderSecond.charAt(j)) {
                    stringBuilderSecond.deleteCharAt(j);
                    stringBuilderLength = stringBuilderSecond.length();
                    break;
                }
            }
        }

        if (stringBuilderSecond.length() == 0) {
            return true;
        }

        return false;
    }

    private static boolean techniqueSecond(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        first = first.toLowerCase();
        second = second.toLowerCase();

        char[] firstWord = first.toCharArray();
        char[] secondWord = second.toCharArray();

        Arrays.sort(firstWord);
        Arrays.sort(secondWord);

        return Arrays.equals(firstWord, secondWord);
    }

    private static boolean techniqueThird(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        int[] letters = new int[128];

        first = first.toLowerCase();
        second = second.toLowerCase();
        for (int i = 0; i < first.length(); i++) {
            letters[first.charAt(i)]++;
        }
        for (int i = 0; i < second.length(); i++) {
            letters[second.charAt(i)]--;

        }
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
