package practice1;

import java.util.Scanner;
public class Paint {
    public static void main(String[] args) {
        final int COVERAGE = 350; //paint covers 350 sq ft/gal
        //declare integers length, width, and height;
        int length, width, height;
        //declare double totalSqFt;
        double totalSqFt;
        //declare double paintNeeded;
        double paintNeeded;
        //declare and initialize Scanner object
        Scanner myScanner = new Scanner(System.in);
        
        //prompt for and read in the length of the room
        System.out.print("Write the length of the room: ");
        length = myScanner.nextInt();
        //Prompt for and read in the width of the room
        System.out.print("Write the width of the room: ");
        width = myScanner.nextInt();
        //Prompt for and read in the height of the room
        System.out.print("Write the height of the room: ");
        height = myScanner.nextInt();
        //Compute the total square feet to be painted--think
        totalSqFt = (length * width) + (length * height * 2) + (width * height * 2);
        //about the dimensions of each wall
        //Compute the amount of paint needed
        paintNeeded = totalSqFt / COVERAGE;
        
        //Print the length, width, and height of the room and the
        //number of gallons of paint needed.
        System.out.println("This is the amount of paint you need: " + paintNeeded);
        
        myScanner.close();
    }
}
