package practice1;
    
    import java.util.Scanner;
    
public class PP5 {
    
    public static void main(String[] args) {
        
        double x1, x2, y1, y2, result;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("This program will show the distance of two coordinates if you write two x and two y.");
        
        System.out.print("Write the x1: ");
        x1 = scan.nextDouble();
        
        System.out.print("Write the y1: ");
        y1 = scan.nextDouble();
        
        System.out.print("Write the x2: ");
        x2 = scan.nextDouble();
        
        System.out.print("Write the y2: ");
        y2 = scan.nextDouble();
        
        result = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        System.out.println("This is the distance of two coordinates: " + result);
    }
}
