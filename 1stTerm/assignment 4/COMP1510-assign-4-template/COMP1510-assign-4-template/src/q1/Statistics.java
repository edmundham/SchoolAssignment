package q1;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * <p>This program will read maximum 50 numbers from the user and compute
 * the mean and standard deviation.</p>
 *
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Statistics {
    
    /**
     * <p>Scanner object.</p>
     */
    private static Scanner scan = new Scanner(System.in);
    
    /**
     * <p>The maximum number of input.</p>
     */
    private static final int MAXINPUT = 50;
    
    /**
     * <p>The sum of inputs.</p>
     */
    private static double sumInput;
    
    /**
     * <p>The mean of inputs.</p>
     */
    private static double average;
    
    /**
     * <p>The standard deviation of inputs.</p>
     */
    private static double standDeviation;
    
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        
        DecimalFormat fmt = new DecimalFormat("0.##");

        System.out.println("Statistics");
        System.out.println("The program will round the mean and "
                + "standard deviation into two decimal places.");
        System.out.println("Enter the numbers you want to compute"
                + " with spaces between:");
        //Reading numbers from user
        String numString = scan.nextLine();
        
        //Setting the maximum number of inputs
        String[] arrayString;
        
        arrayString = numString.split(" ");
        int[] input = new int[MAXINPUT];

        //Make a int array using String array.
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString.length <= MAXINPUT) {
                if (arrayString[i].equals("")) {
                    break;
                } else {
                    input[i] = Integer.parseInt(arrayString[i]);
                }                
            } else {
                if (i < MAXINPUT) {
                    input[i] = Integer.parseInt(arrayString[i]);
                } else {
                    break;
                }
            }
        }
        
        //calculating mean
        for (int i = 0; i < arrayString.length; i++) {
            sumInput += input[i];
        }
        average = sumInput / arrayString.length;
        
        //calculating standard deviation
        for (int i = 0; i < input.length; i++) {
            standDeviation += Math.pow(input[i] - average, 2);
        }
        standDeviation = Math.sqrt(standDeviation
                / (double) (input.length - 1));
        
        System.out.println("This is the mean: " + fmt.format(average));
        System.out.println("This is the standard deviation: "
                + fmt.format(standDeviation));
        
        
    }

};
