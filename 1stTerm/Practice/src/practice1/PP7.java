package practice1;

    import java.util.Scanner;
    import java.text.DecimalFormat;
    
public class PP7 {
    
    public static void main(String[] args) {
        
        double s, a, b, c, area;
        Scanner scan = new Scanner(System.in);
        DecimalFormat fmt = new DecimalFormat("0.###");
        
        System.out.println("This will show the area of the triangle.");
        System.out.print("Write the lengths of one side of the triangle: ");
        a = scan.nextDouble();
        System.out.print("Write the lengths of the other side of the triangle: ");
        b = scan.nextDouble();
        System.out.print("Write the lengths of the other side of the triangle: ");
        c = scan.nextDouble();
        
        s = (a + b + c) / 2;
        area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        
        System.out.println("This is the area of the triangle: " + area);
        
    }
}
