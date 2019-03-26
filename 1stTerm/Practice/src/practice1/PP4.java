package practice1;
    
    import java.util.Scanner;
    import java.text.DecimalFormat;
public class PP4 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        double a;
        int b;
        
        System.out.println("This will show the rounded number that you wrote");
        System.out.print("Write the floating point number: ");
        a = scan.nextDouble();
        
        DecimalFormat fmt = new DecimalFormat("###");
        System.out.println("This is the rounded number: " + fmt.format(a));
    }
}
