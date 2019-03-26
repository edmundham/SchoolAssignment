import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Lab7 {

    private static List<String> q1 = readFile("love.txt");
    private static List<String> q2 = readFile("q2input.txt");

    public static void main(String[] args) {
        q1(q1);
        System.out.println("=========================================");
        q2(q2);
        System.out.println("=========================================");
        q3("q3test.txt");
    }

    private static void q1(List<String> words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, 0);
            } else {
                wordMap.put(word, wordMap.get(word) + 1);
            }
        }

        SortedSet<String> keys = new TreeSet<>(wordMap.keySet());
        for (String key : keys) {
            System.out.println(key + " - " + wordMap.get(key));
        }
    }

    private static void q2(List<String> words) {
        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            if (wordSet.contains(word)) {
                System.out.println("NOT DISTINCT");
                return;
            } else {
                wordSet.add(word);
            }
        }
        System.out.println("DISTINCT");
    }

    private static void q3(String fileName) {
        List<String> keyWords = new ArrayList<>();
        Map<String, Integer> excuses = new HashMap<>();
        int numOfKeyWords;
        int numOfExcuses;

        try (Scanner scan = new Scanner(new File(fileName))) {
            numOfKeyWords = scan.nextInt();
            numOfExcuses = scan.nextInt();
            scan.nextLine();
            for (int i = 0; i < numOfKeyWords; i++) {
                keyWords.add(scan.nextLine());
            }
            for (int i = 0; i < numOfExcuses; i++) {
                excuses.put(scan.nextLine(), 0);
            }
        } catch (Exception e) {
            System.out.printf("Caught Exception: %s%n", e.getMessage());
            e.printStackTrace();
        }

        for (Entry<String, Integer> entry : excuses.entrySet()) {
            int counter = 0;
            for (String keyWord : keyWords) {
                if (entry.getKey().contains(keyWord)) {
                    counter++;
                }
            }
            excuses.put(entry.getKey(), counter);
        }

        int maxValueInMap = Collections.max(excuses.values());
        for (Entry<String, Integer> entry : excuses.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                System.out.println(entry.getKey());
            }
        }

    }

    private static List<String> readFile(String fileName) {
        List<String> aWords = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(fileName))) {
            while (scan.hasNext()) {
                aWords.add(scan.next().toLowerCase());
            }
        } catch (Exception e) {
            System.out.printf("Caught Exception: %s%n", e.getMessage());
            e.printStackTrace();
        }
        return aWords;
    }

}
