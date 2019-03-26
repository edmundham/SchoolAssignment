package practice1;
import java.util.Scanner;
public class IdealWeight {
    public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    int ft, ich, poundW, poundM;
    final int STANDW = 100, STANDM = 106;
    
    System.out.print("Write your height in feet: ");
    ft = myScanner.nextInt();
    
    System.out.print("Write your height in inches: ");
    ich = myScanner.nextInt();
    
    poundW = ((ft - 5) * 12 * 5 ) + (ich * 5) + STANDW;
    poundM = ((ft - 5) * 12 * 6 ) + (ich * 6) + STANDM;
    
    final double PERCENT = 0.85, PERCENTUP = 1.15;
    
    double poundWlow = poundW * PERCENT;
    double poundWhigh = poundW * PERCENTUP;
    double poundMlow = poundM * PERCENT;
    double poundMhigh = poundM * PERCENTUP;
    
    System.out.println("This is ideal weight for the woman: " + poundWlow + " to " + poundWhigh);
    System.out.println("This is ideal weight for the man: " + poundMlow + " to " + poundMhigh);
    
    myScanner.close();
    }
}
