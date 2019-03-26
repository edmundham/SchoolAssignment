package lab3;

    import java.util.Scanner;
    import java.text.NumberFormat;
    import java.text.DecimalFormat;

public class Deli {
    
    // ------------------------------------------------------------------
    //  main reads in the price per pound of a deli item
    //  and number of ounces of a deli item then computes
    //  the total price and prints a "label" for the item
    // ------------------------------------------------------------------
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
                        
        final double OUNCES_PER_POUND = 16.0;
        
        double pricePerPound;       // price per pound
        double weightOunces;        // weight in ounces
        double weight;              // weight in pounds
        double totalPrice;          // total price for the item
        
        // Declare money as a NumberFormat object and use the
        // getCurrencyInstance method to assign it a value
        NumberFormat money = NumberFormat.getCurrencyInstance();

        // Declare fmt as a DecimalFormat object and instantiate
        // it to format numbers with at least one digit to the left of the
        // decimal and the fractional part rounded to two digits.
        DecimalFormat fmt1 = new DecimalFormat("0.##");

        //prompt the user and read in each input
        System.out.println("Welcom to the CS Deli!! \n ");
        
        System.out.print("Enter the price per pound of your team: ");
        pricePerPound = scan.nextDouble();
        
        System.out.print("Enter the weight (ounces): ");
        weightOunces = scan.nextDouble();
        
        // Convert ounces to pounds and compute the total price
        weight = weightOunces / OUNCES_PER_POUND;
        totalPrice = pricePerPound * weight;
        
        // Print the label using the formatting objects
        System.out.println("***** CSDeli *****");
        // fmt for the weight in pounds and money for the prices
        System.out.println();
        System.out.println("Unit Price: " + money.format(pricePerPound) +
                           " per pound");
        System.out.println("Weight: " + fmt1.format(weight) + 
                           " pounds");
        System.out.println();
        System.out.println("TOTAL: " + money.format(totalPrice));
    }
    
}
