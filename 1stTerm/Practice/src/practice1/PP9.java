package practice1;
    import java.util.Random;
public class PP9 {
    public static void main(String[] args) {
        
        int r, h;
        double volume, area;
        Random generator = new Random();
        
        System.out.println("This will compute the volume and area of the cylinder.");
        
        r = generator.nextInt(20) + 1;
        h = generator.nextInt(20) + 1;
        volume = Math.PI * Math.pow(r, 2) * h;
        area = 2 * Math.PI * r * h;
        
        System.out.println("This is radius: " + r);
        System.out.println("This is height: " + h);
        System.out.println("This is volume of cylinder: " + volume);
        System.out.println("This is area of cylinder: " + area);
        
    }
}
