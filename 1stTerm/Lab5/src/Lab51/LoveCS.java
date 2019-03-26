package Lab51;

    import java.util.Scanner;

public class LoveCS {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int limit;
        
        
        int count = 1;
        int sum = 0;
        
        System.out.print("Enter the number you want to repeat the sentence up to 10 times: ");
        limit = scan.nextInt();
        
        while (count <= limit) {
            System.out.println( count + " I love Computer Science!");
            sum += count;
            count++;
        }
        
        System.out.println("Printed this message " + (count - 1) + " times.\n The"
                + " sum of the numbers from 1 to " + (count - 1) + " is " + sum);
    }
}
