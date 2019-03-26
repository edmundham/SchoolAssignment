package lab3;

    import java.util.Scanner;

public class RightTriangle {
    public static void main(String[] args) {
        double side1, side2; //length of the sides of a right triangle
        double hypotenuse;   //length of the hypotenuse
        
        Scanner scan = new Scanner(System.in);
        
        // Get the lengths of the sides as input
        System.out.print("Please enter the lengths of the two sides of " +
                         "a right triangle (separate by a blank space): ");
        side1 = scan.nextDouble();
        side2 = scan.nextDouble();
        System.out.println("This is the side1: " + side1 + " This is the side2: " + side2);
        hypotenuse = Math.sqrt(Math.pow(side1, 2) + Math.pow(side2, 2));
        
        System.out.println("Length of the hypotenuse: " + hypotenuse);
    }
}
