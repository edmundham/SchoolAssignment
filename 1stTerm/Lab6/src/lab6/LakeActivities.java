package lab6;

    import java.util.Scanner;

public class LakeActivities {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int temp;
        
        System.out.println("Welcome to Lake LazyDays Resort!");
        System.out.println("================================");
        System.out.print("Enter the today's temperature (fahrenheit):");
        temp = scan.nextInt();
        System.out.println("=================================================");
        
        System.out.println("We will recommend one great activities for today.");
        System.out.println("=================================================");
        System.out.println("=================================================");
        
        if (temp >= 80) {
            if (temp > 95) {
                System.out.println("Visit our shops!");
            }   else {
            System.out.println("We recommend swimming.");
            }
        }   else if (temp >= 60) {
            System.out.println("We recommend playing tennis.");
        }   else if (temp >= 40) {
            System.out.println("We recommend playing golf.");
        }   else {
            if (temp >= 20) {
                System.out.println("We recommend skiing.");
            }   else {
            System.out.println("Visit our shops!");
            }
        }
    }
}
