package practice1;
import java.util.Scanner;
public class LabGrade {
public static void main(String[] args) {
        double firstpre, firstpost, firstlab, firstaverage;
        Scanner MyScan = new Scanner(System.in);
        //setting an input
        
        System.out.print("Write the student's prelab score out of 30: ");
        firstpre = MyScan.nextDouble();
        firstpre = (firstpre / 30) * 20;
        
        System.out.print("Write the student's in-lab score out of 30: ");
        firstlab = MyScan.nextDouble();
        firstlab = (firstlab / 30) * 60;
        
        System.out.print("Write the student's in-lab score out of 30: ");
        firstpost = MyScan.nextDouble();
        firstpost = (firstpost / 30) * 20;
        
        
        
    }
}
