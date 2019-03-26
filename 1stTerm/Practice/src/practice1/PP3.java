package practice1;
    
    import java.util.Random;
    
public class PP3 {
    public static void main(String[] args) {
        
        Random generator = new Random();
        
        int first, second, third;
        
            first = generator.nextInt(900) + 100;
            second = generator.nextInt(556) + 100;
            third = generator.nextInt(9000) + 1000;
            
        String first1 = new String("" + first);
            
        first1 = first1.replace('9', '4');
        first1 = first1.replace('8', '5');
        
        String second2 = new String("" + second);
        
        String third3 = new String("" + third);
        
        System.out.println(first1 + "-" + second2+ "-" + third3);
    }
}
