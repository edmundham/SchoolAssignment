package q2;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * <p>This program will compute surface area and volume of the cylinder
 * by reading the radius and height that user may enter.</p>
 *
 * @author Sunguk (Edmund) Ham, A00979841, Set E
 * @version 1.0
 */
public class CylinderStats {
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        DecimalFormat fmt = new DecimalFormat("0.####");
        
        // radius of the cylinder.
        double r;
        // height of the cylinder.
        double h;
        // surface area of the cylinder.
        double surfaceArea;
        // volume of the cylinder.
        double volume;
        
        // read the radius and height from the user
        System.out.print("Enter the radius of the "
                + "cylinder you want to use (cm): ");
        r = scan.nextDouble();
        System.out.print("Enter the height of the "
                + "cylinder you want to use (cm): ");
        h = scan.nextDouble();
        
        // show the numbers that user entered
        System.out.println("This is the radius and height you enter:");
        System.out.println("\tRadius: " + r + "cm");
        System.out.println("\tHeight: " + h + "cm");
        
        //compute the surface area and volume of the cylinder
        surfaceArea = (2 * Math.pow(r, 2) * Math.PI) + (2 * Math.PI * r * h);
        volume = Math.PI * Math.pow(r, 2) * h;
        
        // show the result of the calculation.
        // \u33A0 is square centimeter, and \u33A4 is cube centimeter
        System.out.println("This is the surface area of the cylinder: " 
                + fmt.format(surfaceArea) + "\u33A0");
        System.out.println("This is the volume of the cylinder: "
                + fmt.format(volume) + "\u33A4");
    }

};
