package practice1;
    
    import java.util.Scanner;
    
public class PP2 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int a, b, a3rd, b3rd, sum;
        
        System.out.println("This will print the sum of cubes");
        System.out.print("Write the number: ");
            a = scan.nextInt();
        System.out.print("Write the another number: ");
            b = scan.nextInt();
            
        a3rd = (int) Math.pow(a, 3);
        b3rd = (int) Math.pow(b, 3);
        
        sum = a3rd + b3rd;
        
        System.out.println("This is the sume of cubes: " + sum);
    }
}
