package practice1;
    import java.text.DecimalFormat;
    import java.util.Scanner;
public class TextFor {

    public static void main(String[] args) {
        
        double la = 1928.345;
        double lb = 23.4;
        
        double lc = Math.sqrt(la + lb);
        
        DecimalFormat fmt = new DecimalFormat("0.####");
        
        System.out.println(fmt.format(lc));
    }
}
