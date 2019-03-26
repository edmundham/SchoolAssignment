package practice1;
import java.util.*;
import java.text.*;

public class CurrencyPractice {
    public static void main(String[] args) {
        double cost;
        Scanner scan = new Scanner(System.in);
        
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
        
        System.out.print("Enter the cost: " );
        cost = scan.nextDouble();
        
        System.out.println(moneyFormat.format(cost));
        
        
        
        
        
        
    }
}
