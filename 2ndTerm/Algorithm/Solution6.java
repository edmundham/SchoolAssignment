import java.io.*;
import java.util.*;

public class Solution6 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        
        int arrayLength = scan.nextInt();
        int[] arrayNumbers = new int[arrayLength];
        
        for (int i = 0; i < arrayLength; i++) {
            arrayNumbers[i] = scan.nextInt();
        }
        
        int positiveNumbers = 0;
        int negativeNumbers = 0;
        int zeroNumbers = 0;
        
        for (int i = 0; i < arrayLength; i++) {
            if (arrayNumbers[i] == 0) {
                zeroNumbers++;
            } else if (arrayNumbers[i] > 0) {
                positiveNumbers++;
            } else if (arrayNumbers[i] < 0) {
                negativeNumbers++;
            }
        }
        
        double firstLineResult = (double)positiveNumbers / arrayLength;
        double secondLineResult = (double)negativeNumbers / arrayLength;
        double thirdLineResult = (double)zeroNumbers / arrayLength;
        
        System.out.println(firstLineResult);
        System.out.println(secondLineResult);
        System.out.println(thirdLineResult);
        
    }
}