package lab6;

    import java.text.NumberFormat;
    import java.util.Scanner;
    
public class CSCARD {

    public static void main(String[] args) {

        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        NumberFormat fmt1 = NumberFormat.getPercentInstance();
        double newBalance=0, interest, minPayment, preBalance, addCharges;
        double postAddCharges;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter your balance: ");
        preBalance = scan.nextDouble();
        System.out.print("Enter the additional charges: ");
        addCharges = scan.nextDouble();
        
        interest = 1.02;
        
        
        postAddCharges = addCharges * interest;
        newBalance = postAddCharges + preBalance;
        
        if (newBalance < 50) {
            minPayment = newBalance;
        }   else if ((newBalance >=50) && (newBalance <=300)) {
            minPayment = 50;
        }   else {
            minPayment = newBalance * 0.2;
        }
        
        interest = interest - 1;
        
        System.out.println("CS CARD International Statment");
        System.out.println("==============================");
        System.out.println();
        System.out.println("Previous Balance:\t" + fmt.format(preBalance));
        System.out.println("Additional Charges:\t" + fmt.format(addCharges));
        System.out.println("Interest:\t\t" + fmt1.format(interest));
        System.out.println();
        System.out.println("New Balance:\t\t" + fmt.format(newBalance));
        System.out.println();
        System.out.println("Minimum Payment:\t" + fmt.format(minPayment));
            
    }
    
}
