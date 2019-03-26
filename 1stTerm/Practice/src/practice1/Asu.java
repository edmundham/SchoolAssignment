package practice1;
    import java.util.Random;
public class Asu {
    public static void main(String[] args) {
        
        Random generator = new Random();
        
        int a, b, c, d, e, f;
        
        a = generator.nextInt(11);
        b = generator.nextInt(401);
        c = generator.nextInt(10) + 1;
        d = generator.nextInt(400) + 1;
        e = generator.nextInt(26) + 25;
        f = generator.nextInt(26) - 10;
        
        System.out.println(a + b + c + d + e + f);
    }
}
