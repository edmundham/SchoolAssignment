package ca.bcit.lab4;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SpellChecker {

    private final static List<String> aWordList = readFile("lab4_wordlist.txt");
    private final static List<String> aTestData = readFile("lab4_testdata.txt");
    private final static DecimalFormat decimalFormat = new DecimalFormat(".###");
    private static Map<String, Boolean> mTestData;

    public static void main(String[] args) {
        mTestData = initTestWordMap();
        System.out.println(seqSearch());

        mTestData = initTestWordMap();
        System.out.println(binSearch());
    }

    private static int seqSearch() {
        int counter = 0;

        long begin = System.currentTimeMillis();
        for (String testWord : aTestData) {
            for (String wordListWord : aWordList) {
                if (testWord.equalsIgnoreCase(wordListWord)) {
                    mTestData.put(testWord, true);
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Sequential search took " + decimalFormat.format((end - begin) / 1000.0 ) + " seconds");

        for (Boolean value : mTestData.values()) {
            if (!value) {
                counter++;
            }
        }
        return counter;
    }

    private static int binSearch() {
        int counter = 0;

        long begin = System.currentTimeMillis();
        for (String testWord : aTestData) {
            int low = 0;
            int high = aWordList.size() - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (aWordList.get(mid).toLowerCase().compareTo(testWord.toLowerCase()) < 0) {
                    low = mid + 1;
                } else if (aWordList.get(mid).toLowerCase().compareTo(testWord.toLowerCase()) > 0) {
                    high = mid - 1;
                } else {
                    mTestData.put(testWord, true);
                    break;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("Binary search took " + decimalFormat.format((end - begin) / 1000.0 ) + " seconds");

        for (Boolean value : mTestData.values()) {
            if (!value) {
                counter++;
            }
        }

        return counter;
    }

    private static List<String> readFile(String fileName) {
        List<String> aWords = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(fileName))) {
            while (scan.hasNext()) {
                aWords.add(scan.next());
            }
        } catch (Exception e) {
            System.out.printf("Caught Exception: %s%n", e.getMessage());
            e.printStackTrace();
        }
        return aWords;
    }

    private static Map<String, Boolean> initTestWordMap() {
        Map<String, Boolean> mTempTestData = new HashMap<>();
        for (String testWord : aTestData) {
            mTempTestData.put(testWord, false);
        }
        return mTempTestData;
    }
}
