import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution9 {

    static int birthdayCakeCandles(int n, int[] ar) {
        // Complete this function
        // find the max num of the array, and count them
        // and when we found new max, count = 0
        // n is the length of the array
        int count = 0;
        int max = ar[0];
        for (int i = 0; i < n; i++) {
            if (ar[i] > max) {
                count = 0;
                max = ar[i];
            }
            if (ar[i] == max) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
