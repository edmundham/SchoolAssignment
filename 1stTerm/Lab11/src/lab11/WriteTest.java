package lab11;

import java.util.Scanner;

public class WriteTest {

    private static Scanner scan = new Scanner(System.in);
    
    private static char typeQ;
    
    public static void main(String[] args) {
        
        System.out.print("Enter the type of a question: ");
        typeQ = scan.next().charAt(0);
        
    }
    
}
