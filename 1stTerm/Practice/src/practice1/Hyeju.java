package practice1;
    
    import java.text.NumberFormat;
    
public class Hyeju {
    
    public static void main(String[] args) {
        
        NumberFormat fmt = NumberFormat.getPercentInstance();
        
        String sungUk = "HyeJu";
        
        System.out.println(sungUk.replace('H', 'J'));
        System.out.println(sungUk);
        
        float b = 54.54f;
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println(fmt.format(b));
    }
}
