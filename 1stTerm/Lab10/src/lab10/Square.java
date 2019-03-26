package lab10;

import java.util.Scanner;

public class Square {

    int[][] square;
    private int rowSum;
    private int colSum;
    private int mainSum;
    private int otherSum;
    
    public Square(int size) {
        square = new int[size][size];
    }
    
    public int sumRow(int row) {
        int[] rowNum = square[row];
        for (int i = 0; i < rowNum.length; i++) {
            rowSum += rowNum[i];
        }
        return rowSum;
    }
    
    public int sumCol(int col) {
        int[] colNum = new int[square.length];
        for (int i = 0; i < square.length; i++) {
            colNum[i] = square[i][col];
            colSum  += colNum[i];
        }
        return colSum;
    }
    
    public int sumMainDiag() {
        for (int i = 0; i < square.length; i++) {
            mainSum += square[i][i];
        }
        return mainSum;
    }
    
    public int sumOtherDiag() {
        for (int i = 0; i < square.length; i++) {
            otherSum += square[i][square.length-(i+1)];
        }
        return otherSum;
    }
    
    public boolean magic() {
//        System.out.println(rowSum + " " + colSum + " " 
//                + mainSum + " " + otherSum);
            if (rowSum == colSum
                    && colSum == mainSum
                    && mainSum == otherSum) {
                return true;
            }
            return false;
    }
    
    public void readSquare(Scanner scan) {
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square.length; col++) {
                square[row][col] = scan.nextInt();
            }
        }
    }
    
    public void printSquare() {
        for (int[] num : square) {
            for (int numnum : num) {
            System.out.print(numnum + " ");
            }
            System.out.println();
        }
    }
    
}
