package chapter41;
    
    import java.util.Scanner;

public class Phone {
    
    Scanner scan = new Scanner(System.in);
    private String make;
    private String model;
    private int year;
    private boolean determine;
    private String old;
    
    public Phone() {
        
    }
    
    public void setInfo() {
        System.out.println("This program will determine whether your phone" +
                           " is obsolete or not.");
        System.out.println();
        System.out.println();
        System.out.print("Enter your phone's company: ");
        make = scan.next();
        System.out.print("Enter your phone's model: ");
        model = scan.next();
        System.out.print("Enter the year that your phone was made: ");
        year = scan.nextInt();
    }
    
    public boolean obsolete() {
        determine = (2017 - year) > 10;
        return determine;
    }
    
    public String toString() {
        if (determine = true) {
            old = "obsolete";
        }  else {
            old = "not obsolete";
        }
        return "\n" + model + " made by " + make + " is " + old;
    }
}
