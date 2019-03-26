package lab6;

import java.util.Random;
import java.util.Scanner;

public class Rock {

    public static void main(String[] args) {
        String personPlay;      // r p s
        String computerPlay;    // r p s
        int computerInt;        // determine computer's r p s
        
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
        
        System.out.println("$ java Rock");
        System.out.println("Enter your play: R, P, or S");
        personPlay = scan.nextLine().substring(0, 1);
        
        personPlay = personPlay.toUpperCase();
        
        computerInt = generator.nextInt(3);
        
        switch(computerInt) {
        case 0:
            computerPlay = "R";
            break;
        case 1:
            computerPlay = "P";
            break;
        default:
            computerPlay = "S";
        }
        
        System.out.println("Computer play is " + computerPlay);
        
        if (personPlay.equals(computerPlay)) {
            System.out.println("It's a tie!");
        }   
        
        else if (personPlay.equals("R")) {
            if (computerPlay.equals("S")) {
                System.out.println("Rock crushes scissors. You win!!");
            }   else {
                System.out.println("You loose.");
            }
        }  
        
        else if (personPlay.equals("S")) {
            if (computerPlay.equals("P")) {
                System.out.println("You win!!");
            }   else {
                System.out.println("You loose.");
            }
        }   
        
        else if (personPlay.equals("P")) {
            if (computerPlay.equals("R")) {
                System.out.println("You win!!");
            }   else {
                System.out.println("You loose.");
            }
        }
        
        
        
        
        
        
        
        
        
    }
}
