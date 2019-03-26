package lab4;

import java.util.Scanner;

public class BandBooster {
    
    private String name;
    private int boxesSold;
    private int thisweekbox;
    
    Scanner scan = new Scanner(System.in);
    
    public BandBooster(String candyName) {
        name = candyName;
        boxesSold = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public void updateSales() {
        System.out.print("Enter the number of boxes of candy sold by " + name + " this week: ");
        thisweekbox = scan.nextInt();
        boxesSold += thisweekbox;
    }
    
    public String toString() {
        return name + ": \t" + boxesSold + " boxes";
    }
}
