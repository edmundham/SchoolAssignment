import java.io.*;
import java.util.*;

public class Solution5 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int widthHeight = scan.nextInt();
        int[][] matrix = new int[widthHeight][widthHeight];
        int argsIndexCounter = 0;
        for (int i = 0; i < widthHeight; i++) {
            for (int j = 0; j < widthHeight; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        int firstDiagonal = 0;
        int secondDiagonal = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            firstDiagonal += matrix[i][i];
        }
        for (int i = 0; i < matrix[0].length; i++) {
            secondDiagonal += matrix[i][--widthHeight];
        }
        
        int difference = 0;
        if (firstDiagonal < secondDiagonal) {
            difference = secondDiagonal - firstDiagonal;
        } else if (firstDiagonal > secondDiagonal) {
            difference = firstDiagonal - secondDiagonal;
        } else {
            difference = 0;
        }
        
        System.out.println(difference);
        
    }
}