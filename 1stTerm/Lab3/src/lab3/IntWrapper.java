package lab3;
    import java.util.Scanner;
    import java.math.*;
    
public class IntWrapper {
    
    public static void main(String[] args) {
    
    Integer input;            

    Scanner scan = new Scanner(System.in);
    
    System.out.print("Enter the number in decimal base: ");
    input = scan.nextInt();
    
    String output1, output2, output3;
    output1 = Integer.toBinaryString(input);
    output2 = Integer.toHexString(input);
    output3 = Integer.toOctalString(input);
    
    System.out.println("This is binary number: " + output1);
    System.out.println("This is Hexadecimal number: " + output2);
    System.out.println("This is Octal number: " + output3);
    
    }
}