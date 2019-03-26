package q2;

import java.util.Random;
import java.util.Scanner;

/**
 * <p>This program is the modification of Rock.java in the lab.
 * The things added are that the program will iterate until the
 * user wants to stop, will print what user entered, and will print
 * more precise instruction at first.</p>
 *
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class RockPaperScissors {
    
    /**
     * <p>Static string that reads string from the user.</p>
     */
    private static String personPlay = "R";

    /**
     * <p>Static string that changes R, S, P depends on the random
     * integer.</p>
     */
    private static String computerPlay;

    /**
     * <p>Static integer that generates random number 0, 1, or 2.</p>
     */
    private static int computerInt;

    /**
     * <p>Static constant that is used for the maximum number of random
     * number.</p>
     */
    private static final int PLAYNUM = 2;

    /**
     * <p>Static integer that is used for counting the number of win.</p>
     */
    private static int win;

    /**
     * <p>Static integer that is used for counting the number of loose.</p>
     */
    private static int loose;

    /**
     * <p>Static integer that is used for counting the number of tie.</p>
     */
    private static int tie;

    /**
     * <p>Static scanner that is used to reads input from the user.</p>
     */
    private static Scanner scan = new Scanner(System.in);

    /**
     * <p>Static random that is used to generate 0, 1, or 2.</p>
     */
    private static Random generator = new Random();

    
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        
        // Giving instructions
        System.out.println("$ java Rock"
                + "\nInstruction: You can enter R, P, or S or "
                + "Rock, Paper, or Scissors.\n\tIf you want to quit the "
                + "program, enter q to quit.");
        
        // While loop that stops when user enter Quit.
        while (!"Q".equals(personPlay)) {
            
            // scan user's input and substring the first character
            // which will be r, p, or s
            System.out.println("Enter your play: R, P, or S");
            personPlay = scan.nextLine().substring(0, 1).toUpperCase();
            if (!(personPlay.equals("R")
                    || personPlay.equals("S")
                    || personPlay.equals("P")
                    || personPlay.equals("Q"))) {
                throw new IllegalArgumentException("Illegeal Input, you must"
                        + " enter R, S, P, or Q.");
            }
            
            // if user inputs q, program will stop
            // if user inputs r, p, or s, program will continue
            // if statement ends at line 104
            if ("R".equals(personPlay)
                    || "S".equals(personPlay)
                    || "P".equals(personPlay)) {
                
                // randomly declare to 0, 1, or 2
                computerInt = generator.nextInt(PLAYNUM + 1);
        
                // if random object gives 0, results in Rock.
                // if random object gives 1, results in Paper.
                // if random object gives 2, results in Scissors.
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
                
                System.out.println("Computer play is " + computerPlay 
                        + "\nYour play is " + personPlay);
                
                // if computerplay and personplay equals, 
                // terminate if statement very first,
                // but if it's not, if statement will
                // compare each rock, paper, and scissors.
                if (personPlay.equals(computerPlay)) {
                
                    System.out.println("It's a tie!");
                    tie++;
                    
                }   else if (personPlay.equals("R")) {
                    
                        if (computerPlay.equals("S")) {
                            System.out.println("Rock crushes scissors. "
                                    + "You win!!");
                            win++;
                        }   else {
                                System.out.println("You loose."); 
                                loose++;
                            }
                    
                    }  else if (personPlay.equals("S")) {
                    
                            if (computerPlay.equals("P")) {
                                System.out.println("You win!!");
                                win++;
                            }   else {
                                    System.out.println("You loose.");
                                    loose++;
                                }
                    
                       }   else if (personPlay.equals("P")) {
                    
                                if (computerPlay.equals("R")) {
                                    System.out.println("You win!!");
                                    win++;
                                }   else {
                                        System.out.println("You loose.");
                                        loose++;
                                    }
                    
                           }
            }
        }
        System.out.println("Loose: " + loose + "\nWin: " + win + "\nTie: "
                + tie);

    }
}
