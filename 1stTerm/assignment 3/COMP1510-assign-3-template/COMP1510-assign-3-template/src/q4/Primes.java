package q4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>This is the program that reads the maximum number from user,
 * calculate 0 to the number that which number is prime number,
 * count how many numbers are prime number and print all the prime
 * numbers with the number of prime numbers.</p>
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Primes {
    
    /**
     * <p>Static boolean array that is declared inside the constructor
     * using Arrays method.</p>
     */
    private static Boolean[] primeArray;
    
    /**
     * <p>The maximum number of indices of array.</p>
     */
    private static final int MAXUPPERBOUNDS = 1001;
    
    /**
     * <p>Constructor that has the number that user enter
     * and two methods, one declaring boolean array with the index of
     * the number user enter, the other determining which number is
     * prime number.</p>
     * 
     * @param num is used for declaring index of array, and parameter will 
     * be added 1, then the maximum index will be the number that user enter
     */
    public Primes(int num) {
        primeArray = array(num + 1);
        calculatePrimes(primeArray);
    }
    
    /**
     * <p>This is the method that declaring boolean array.
     * Array has index of the number user enters, and except index 0 and 1,
     * all other elements are true.</p>
     * 
     * @param num is used for declaring index of array
     * @return boolean array has elements that is all true except
     *  0 and 1 index
     */
    private static Boolean[] array(int num) {
        if (1 >= num || num > MAXUPPERBOUNDS) {
            throw new ArrayIndexOutOfBoundsException("You must enter the "
                    + "number between 1 and 1000 to make the program run "
                    + "properly and to save the memory space.");
        }
        
        Boolean[] primeArrayLocal = new Boolean[num];
        Arrays.fill(primeArrayLocal, true);
        primeArrayLocal[0] = false;
        primeArrayLocal[1] = false;
        return primeArrayLocal;
    }
    
    /**
     * <p>This method calculates indices of array whether that index
     * is prime number or not.</p>
     * 
     * @param booleanArray is used for determining which index is
     * prime number
     */
    private static void calculatePrimes(Boolean[] booleanArray) {
        if (booleanArray.length < 2 || booleanArray.length > MAXUPPERBOUNDS) {
            throw new IllegalArgumentException("You must enter the number "
                    + "between 1 and 1000 to make the program run properly "
                    + "and to save the memory space.");
        }
        
        //Make a list of natural numbers
        //Starts with 2 since number 0 and 1 cannot be prime
        for (int i = 2; i < booleanArray.length; i++) {
            
            // make a list of multiples of natural numbers
            // the for loop below contains natural numbers used
            // for multiples
            // starts with 2 since it does not need to multiply 0 and 1
            if (booleanArray[i]) {
                booleanArray[i] = true;
            }
            for (int q = 2; q < booleanArray.length / 2; q++) {
                if (i * q < booleanArray.length) {
                    booleanArray[i * q] = false;
                }
            }
        //End of for loop
        }

    }
    
    /**
     * <p>This method prints the prime number which is the index
     * number of array that is true.</p>
     */
    private void printPrimes() {
        if (primeArray.length < 2 || primeArray.length > MAXUPPERBOUNDS) {
            throw new ArrayIndexOutOfBoundsException("You must "
                    + "enter the number "
                    + "between 1 and 1000 to make the program run properly "
                    + "and to save the memory space.");
        }
        
        for (int i = 0; i < primeArray.length; i++) {
            if (primeArray[i]) {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * <p>This method counts how many prime numbers inside
     * the range that user enter.</p>
     *
     * @return the number of prime numbers in the range
     */
    private int countPrimes() {
        if (primeArray.length < 2 || primeArray.length > MAXUPPERBOUNDS) {
            throw new ArrayIndexOutOfBoundsException("You must "
                    + "enter the number "
                    + "between 1 and 1000 to make the program run properly "
                    + "and to save the memory space.");
        }
    
        int countingPrime = 0;
        for (int i = 0; i < primeArray.length; i++) {
            if (primeArray[i]) {
                countingPrime++;
            }
        }
        return countingPrime;
    }
    
    /**
     * <p>This method returns true if parameter x is prime number.
     * Since instruction does not say about calling isPrime method, 
     * main method does not invoke this method. However, isPrime is made
     * up of simple logic using static array.</p>
     * 
     * @param x is determined whether it is prime number or not
     * @return true if parameter is prime number
     */
    private boolean isPrime(int x) {
        if (0 >= x || x > MAXUPPERBOUNDS - 1) {
            throw new IllegalArgumentException("Parameter should be "
                    + "between 0 and 1000 since those numbers "
                    + "are the valid indices of the array.");
        }
        return primeArray[x];
    }
    
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     * 
     * @param args unused
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        // used for reading user input and object parameter
        int range;
        
        // Read user input
        System.out.println("This program uses the sieve of Eratosthenese "
                + "to determine which numbers are prime."
                + "\nSince array in Java need allocating a lot of memory,"
                + " do not enter the number more than 1,000.");
        System.out.println("Enter an upper bound:");
        range = scan.nextInt();
        
        // Object has primeArray now
        Primes primeObj = new Primes(range);
        
        // Count how many prime numbers there are and print the number of
        // prime numbers.
        System.out.println("There are " + primeObj.countPrimes()
                + " primes:");
        
        // Print all the prime numbers
        System.out.println("The prime numbers between 0 and "
                + range + " are:");
        primeObj.printPrimes();
    }
     
}
