import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution8 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] arr = new long[5];
        long sum = 0;
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
            sum += arr[arr_i];
        }
        
        // arr is an array with 5 integers
        // find min and max first
        long min = arr[0];
        long max = arr[0];
        for (int i = 0; i < 5; i++) {
            if (arr[i] <= min) {
                min = arr[i];
            }
            if (arr[i] >= max) {
                max = arr[i];
            }
        }
        // minSum, and maxSum using sum and min and max
        long minSum = sum - max;
        long maxSum = sum - min;
        
        System.out.print(minSum + " " + maxSum);
        
    }
}
