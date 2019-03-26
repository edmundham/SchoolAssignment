package lab3;
    import java.util.Random;
public class Myrollingdice {
    
    public static void main(String[] args) {
        Random ran = new Random();
        
        int a, b, c;
        a = ran.nextInt(6) + 1;
        System.out.println("This is the result of rolling die1: " + a);
        b = ran.nextInt(6) + 1;
        System.out.println("This is the result of rolling die2: " + b);
        
        c = a + b;
        
        System.out.println("This is the sum of two dice:" + c);
    }
}
