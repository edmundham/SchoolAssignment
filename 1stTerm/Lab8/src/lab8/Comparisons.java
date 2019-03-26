package lab8;

import java.util.Scanner;

public class Comparisons {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter the 3 sentences or words:");
        String val1 = scan.next();
        
        String val2 = scan.next();
        
        String val3 = scan.next();
        
        System.out.println(Compare3.largest(val1, val2, val3));
    }
}
