package lab6;

import java.util.Scanner;
import java.util.Random;

public class Guess {

    public static void main(String[] args) {
        
        int numToGuess;
        int guess;
        int count = 1;
        int countLow = 0;
        int countHigh = 0;
        
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
        
        //randomly generate the number to guess
        guess = generator.nextInt(9) + 1;
        
        //print message asking user to enter a guess
        
        do {
            System.out.print("Enter your guess 1 to 10: ");
            numToGuess = scan.nextInt();
            
            System.out.println("===================================");

            System.out.println("You entered " + numToGuess + ".");

            if (guess == numToGuess) {
                System.out.println("Right! You've tried " + count + " times.");
                System.out.println("The number of times you entered higher number: " + countHigh);
                System.out.println("The number of times you entered lower number: " + countLow);
            }
            
            if (guess > numToGuess) {
                System.out.println("It's too low.");
                countLow++;
            }   else if (guess < numToGuess) {
                System.out.println("It's too high.");
                countHigh++;
            }
            
            if (guess != numToGuess) {
                System.out.println("You've tried " + count + " times.");
                count++;
            }
            
        }   while (guess != numToGuess);
        
        
        
        
    /*    while (guess != numToGuess) {
            
            System.out.println("You entered " + numToGuess +".");
            
            if (guess > numToGuess) {
                System.out.println("It's too low.");
                countLow++;
            }   else {
                System.out.println("It's too high.");
                countHigh++;
            }
            
            System.out.println("You've tried " + count + " times.");
            count++;
            
            System.out.print("Enter your guess again: ");
            numToGuess = scan.nextInt();
            
            System.out.println("________________________");
        }
        */
    }
}
