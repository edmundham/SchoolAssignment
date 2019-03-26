package lab4;

    import java.util.Scanner;
    
public class Factorial {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int number;
        int factorial = 1;
        
        System.out.print("Enter the number you want to compute to factorial (non-negative): ");
        number = scan.nextInt();
        
        while ( number < 0 ) {
            System.out.print("Enter again: ");
            number = scan.nextInt();
        }
        
        System.out.print(number + "! = ");

        while ( number > 0 ) {
            factorial *= number--;
            //To make simple
            // Original:
            // factorial *= number;
            // number--;
            
        }
        
        System.out.println(factorial);
    }
}
