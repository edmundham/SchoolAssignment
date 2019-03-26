package practice1;

    import java.util.Random;

public class PP8 {

    public static void main(String[] args) {
        
     int a;
     double sin, cos, tan;
     Random generator = new Random();
     
     System.out.println("This program will show sine, cosine, and tangent of the random degree.");
     a = generator.nextInt(21) + 20;
     
     sin = Math.sin(a);
     cos = Math.cos(a);
     tan = Math.tan(a);
     
     System.out.println("This is the degree: " + a);
     System.out.println("This is the sine: " + sin);
     System.out.println("This is the cosine: " + cos);
     System.out.println("This is the tangent: " + tan);
    }
}
