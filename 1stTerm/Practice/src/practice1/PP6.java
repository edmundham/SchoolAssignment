package practice1;
    
    import java.util.Scanner;
    import java.text.DecimalFormat;
    
public class PP6 {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        double r, volume, surfaceArea;
        DecimalFormat fmt = new DecimalFormat("0.####");
        
        System.out.println("This will calculate Volume and Surface Area of a sphere using the radius you will write.");
        System.out.print("Write the radius: ");
        r = scan.nextDouble();
        
        volume = Math.PI * (4 / 3) * Math.pow(r, 3);
        surfaceArea = 4 * Math.PI * Math.pow(r, 2);
        
        System.out.println("This is the volume of sphere: " + fmt.format(volume));
        System.out.println("This is the surface area of shpere: " + fmt.format(surfaceArea));
        
    }
}
