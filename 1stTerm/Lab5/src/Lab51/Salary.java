package Lab51;

    import java.util.Scanner;
    import java.text.NumberFormat;
    
public class Salary {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        double currentSalary;   //current annual salary
        String rating;          //performance rating
        double raise;          //dollar amount of the raise
        double newSalary;       //new salary for the employee
        
        //  Get the current salary and performance rating
        System.out.print("Enter the current salary: ");
        currentSalary = scan.nextDouble();
        System.out.print("Enter the performance rating (Excellent, Good, or Poor): ");
        rating = scan.next();
        
        //Compute the raise -- Use if ... else ...
        
        if ( rating.equalsIgnoreCase("Excellent") ) {
            raise = currentSalary * 0.06;
        }   else if ( rating.equalsIgnoreCase( "Good" ) ) {
            raise = currentSalary * 0.04;
        }   else {
            raise = currentSalary * 0.015;
        }
        
        
        newSalary = raise + currentSalary;
        
        // Print the results
        NumberFormat money = NumberFormat.getCurrencyInstance();
        System.out.println();
        System.out.println("Current Salary:          " + money.format(currentSalary));
        System.out.println("Amount of your raise:    " + money.format(raise));
        System.out.println("Your new salary:         " + money.format(newSalary));
        System.out.println();
        
    }
}

