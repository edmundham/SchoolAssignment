package practice1;
import java.util.Scanner;

public class MoneyChange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double money, postPointbefore, postPoint;
        int twentybill, tenbill, fivebill, toonies, loonies, quarters,
            dimes, nickels, prePoint, pennies;
        
        System.out.print("Write the amount of money: ");
        money = scan.nextDouble(); 
        prePoint = (int) money / 1;
        postPointbefore = money - prePoint;
        postPoint = postPointbefore * 100;
        twentybill = prePoint / 20;
        tenbill = (prePoint % 20) / 10;
        fivebill = ((prePoint % 20) % 10) / 5;
        toonies = (((prePoint % 20) % 10) % 5) / 2;
        loonies = ((((prePoint % 20) % 10) % 5) % 2) / 1;
        quarters = (int) (postPoint / 25);
        dimes = (int) (postPoint % 25) / 10;
        nickels = (int) ((postPoint % 25) % 10) / 5;
        pennies = (int) (((postPoint % 25) % 10) % 5) / 1;
                
        System.out.println(twentybill + " 20 bills");
        System.out.println(tenbill + " 10 bills");
        System.out.println(fivebill + " 5 bills");
        System.out.println(toonies + " Toonies");
        System.out.println(loonies + " Loonies");
        System.out.println(quarters + " Quarters");
        System.out.println(dimes + " Dimes");
        System.out.println(nickels + " Nickels");
        System.out.println(pennies + " Pennies");
    }
}