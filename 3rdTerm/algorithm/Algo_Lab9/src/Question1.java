import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Question1 {

    public static void main(String[] args) {
        q1();
        q2();
    }

    private static void q1() {
        int numOfTestCases;
        try (Scanner scan = new Scanner(new File("q1input.txt"))) {
            numOfTestCases = Integer.parseInt(scan.nextLine());
            int numOfAlbums;
            for (int i = 0; i < numOfTestCases; i++) {
                List<String> originalOrderOfAlbum = new ArrayList<>();
                List<String> stackOfAlbums = new ArrayList<>();
                numOfAlbums = Integer.parseInt(scan.nextLine());
                for (int j = 0; j < numOfAlbums; j++) {
                    originalOrderOfAlbum.add(scan.nextLine());
                }
                for (int j = 0; j < numOfAlbums; j++) {
                    stackOfAlbums.add(scan.nextLine());
                }

                int originalIndex = originalOrderOfAlbum.size() - 1;
                int albumIndex = stackOfAlbums.size() - 1;
                while (originalIndex >= 0) {
                    if (originalOrderOfAlbum.get(originalIndex).equals(stackOfAlbums.get(albumIndex))) {
                        originalIndex -= 1;
                        albumIndex -= 1;
                    } else {
                        originalIndex -= 1;
                    }
                }
                while (albumIndex >= 0) {
                    System.out.println(stackOfAlbums.get(albumIndex--));
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.printf("Caught Exception: %s%n", e.getMessage());
            e.printStackTrace();
        }
    }

    private static void q2() {
        int numOfTestCases;
        try (Scanner scan = new Scanner(new File("q2input.txt"))) {
            numOfTestCases = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < numOfTestCases; i++) {
                scan.nextLine();
                String input;
                Set<String> words = new HashSet<>();
                while (!(input = scan.nextLine()).equals("*")) {
                    words.add(input);
                }
                //for each pair
                while (scan.hasNextLine()) {
                    String original = scan.next();
                    String target = scan.next();
                    Queue<String> queue = new LinkedList<>();
                    queue.add(original);
                    queue.add(null);

                    Set<String> visited = new HashSet<String>();
                    visited.add(original);
                    int level = 0;
                    whileloop:
                    while(!queue.isEmpty()) {
                        String word = queue.poll();
                        if (word != null) {
                            for (int k = 0; k < word.length(); k++) {
                                char[] chars = word.toCharArray();
                                for (char c = 'a'; c <= 'z'; c++) {
                                    chars[k] = c;
                                    String temp = new String(chars);
                                    if (temp.equals(target)) {
                                        System.out.println(original + " " + target + " " + (level + 1));
                                        break whileloop;
                                    }
                                    if (words.contains(temp) && !visited.contains(temp)) {
                                        queue.add(temp);
                                        visited.add(temp);
                                    }
                                }
                            }
                        } else {
                            level++;
                            if (!queue.isEmpty()) {
                                queue.add(null);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.printf("Caught Exception: %s%n", e.getMessage());
            e.printStackTrace();
        }
    }
}
