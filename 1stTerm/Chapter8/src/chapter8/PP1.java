package chapter8;

import java.util.Scanner;

/**
 * <p>The program reads an arbitrary number of even integers that are
 *  in the range 2 to 100 inclusive and counts how many occurrences
 *  of each are entered.</p>
 * <ol>
 *  <li>Scan user input.
 *  <li>Throws exceptions if user enters the number out of the range.
 *  Or rather ask to user enter again. To make the program fluent.
 *  <li>Store that number into the array.
 *  <li>Asking user to input again.
 *  <li>If all inputs are finished, calculate how many occurrences happen.
 *  <li>Print all the values with the number of occurrences.
 * </ol>
 * 
 * @author Sunguk (Edmund) Ham
 * @version 1.0
 *
 */
public class PP1 {
    
    /**
     * <p>Scanner object.</p>
     */
    private Scanner scan = new Scanner(System.in);
    
    /**
     * <p>Scanning integer from user.</p>
     */
    private int scanInt;

    /**
     * <p>Storing integer input from user.</p>
     */
    private int[] array;
    
    /**
     * <p>Index number of array from 0.</p>
     */
    private int arrayIndex;
    
    /**
     * <p>Asking user to enter again.</p>
     */
    private String again = "y";
    
    /**
     * <p>The number of occurrences.</p>
     */
    private int occurrences;
    
    /**
     * <p>Method that read numbers from user.</p>
     */
    private void readNumber() {
        while (again.equals("y")) {
            System.out.println("Please enter the even integers between"
                    + "2 and 100 inclusive.");
            scanInt = scan.nextInt();
            
            //If the input is not valid
            if (scanInt / 2 != 0 || scanInt <= 2 || scanInt >= 100) {
                System.out.println("Please enter again, the number you"
                        + " entered is not valid.");
                scanInt = scan.nextInt();
            }
            
            //Storing into an array.
            array[arrayIndex] = scanInt;
            arrayIndex++;
            
            System.out.println("Do you want to enter again?");
            again = scan.next().toLowerCase().substring(0, 1);
        }
    }
    
    /**
     * <p>Count how many occurrences happen.</p>
     */
    private void countOccurrence() {
        for (int i = 0; i < array.length; i++) {
            occurrences = 0;
            for (int q = 0; q < array.length; q++) {
                if (array[i] == array[q]) {
                    occurrences++;
                }
                if (occurrences != 0) {
                    System.out.println(array[i] 
                            + " occurs " + occurrences);                    
                }
            }
        }
        
    }
    
    /**
     * <p>Main method.</p>
     * 
     * @param args unused
     */
    public static void main(String[] args) {
        
        
        
    }
    
}
