package chapter41;

import java.util.Scanner;

public class Circle {

Scanner scan = new Scanner(System.in);

private double circumference;
private double area;
private double inradius;

public Circle() {
    inradius = 0;
}

public void setRadius() {
    System.out.print("Enter the radius: ");
    inradius = scan.nextDouble();
}

public double getRadius() {
    return inradius;
}

public double getCircumference() {
    return circumference = 2 * inradius * Math.PI;
}

public double getArea() {
    return area = Math.PI * Math.pow(inradius, 2);
}

public String toString() {
    return "Radius that you enter: " + inradius + "\n"
            + "Circumference is: " + circumference + "\n"
            + "Area is: " + area;
}
}
