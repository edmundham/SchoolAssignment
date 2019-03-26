package practice1;
    import java.text.DecimalFormat;
    import java.util.Scanner;
    
    public class Power4 {
        public static void main(String[] args) {
            
            double power;
            Scanner scan = new Scanner(System.in);
            
            System.out.print("Write the number you want to do 4th power: ");
            power = scan.nextDouble();
            
            power = Math.pow(power, 4);
            DecimalFormat fmt = new DecimalFormat("0.####");
            
            System.out.println("This is the 4th power of the number: " + fmt.format(power));
        }
}
