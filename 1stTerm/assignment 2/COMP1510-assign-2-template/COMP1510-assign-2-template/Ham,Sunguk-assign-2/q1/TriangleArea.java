package q1;

import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * <p>This program will be using Heron's formula in order to compute a
 *  triangle's area by reading lengths of the three sides. Those
 *  lengths will be helping compute perimeter of the triangle. </p>
 *
 * @author Sunguk (Edmund) Ham, A00979841, Set E
 * @version 1.0
 */

public class TriangleArea {
    
/**
* <p>This is the main method (entry point) that gets called by the JVM.</p>
*
* @param args unused.
*/
    public static void main(String[] args) {
        // your code will go here!!!
        
        Scanner scan = new Scanner(System.in);
        
        DecimalFormat fmt = new DecimalFormat("0.###");
        
        // one of the sides of the triangle
        double a;
        double b;
        double c;
        
        // perimeter of the triangle / 2
        double s;
        
        // area of the triangle
        double area;
        

        //Reads three numbers from the user.
        System.out.print("Enter the lengths of three sides of the"
                + " triangle with a space you want to compute (cm): ");
        a = scan.nextDouble();
        b = scan.nextDouble();
        c = scan.nextDouble();
        
        // compute s which is used for Heron's formula
        s = (a + b + c) / 2;
        
        // compute area
        area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        
        System.out.println();
        
        // show the well-organized results.
        System.out.println("This is the number you wrote: "
                + a + "cm, " + b + "cm, and " + c + "cm");
        // \u33A0 is square centimeter
        System.out.println("Area of the triangle is: "
                + fmt.format(area) + "\u33A0");
        
    }

};
