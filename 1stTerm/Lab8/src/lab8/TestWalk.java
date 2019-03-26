package lab8;

import java.util.Scanner;

/**
 * Program to test methods in the RandomWalk class.
 * 
 * @author ham29
 *
 */
public class TestWalk {

    public static void main(String[] args) {
        
        //maximum number of steps in a walk
        int maxSteps;
        //the maximum x and y coordinate
        int maxCoord;
        //starting x an dy coordinates for a walk
        int x, y;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\nRandom Walk Test Program");
        System.out.println();
        
//        System.out.println("Enter the boundary for the square: ");
//        maxCoord = scan.nextInt();
        
//        System.out.println("Enter the maximum number of steps: ");
//        maxSteps = scan.nextInt();
        
//        System.out.println("Enter the starting x and y coordinates with " 
//        + "a space between: ");
//        
//        x = scan.nextInt();
//        y = scan.nextInt();
        
        maxCoord = 10;
        maxSteps = 200;
        x = 0;
        y = 0;
        
//        RandomWalk rW1 = new RandomWalk(5, 10);
        RandomWalk rW2 = new RandomWalk(maxSteps, maxCoord, x, y);
        
//        for (int i = 0; i < 5; i++) {
//            
//            rW1.takeStep();
//            rW2.takeStep();
//            System.out.println(rW1); 
//            System.out.println(rW2);
//            System.out.println("=========================");
//        }
        
//        for (int i = 0; i < 10; i++) {
//            rW1.walk();
//            System.out.println(rW1);
//        }
        
        System.out.println("============================");
        
        for (int i = 0; i < maxSteps; i++) {
            
            rW2.walk();
            rW2.getCount();
            System.out.println(rW2);
            
        }
        System.out.println("Farthest distance: "+rW2.getMaxDistance());
        
    }
}
