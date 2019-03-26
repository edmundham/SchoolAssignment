package lab6;

    import java.util.Scanner;

public class Temps {

    public static void main(String[] args) {
        final int hoursPerDay = 24;
        int temp= 0;
        int tempTemporary;
        int tempMax = -99999;
        int tempMin = 99999;
        int maxHour = 0;
        int minHour = 0;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println();
        System.out.println("Temperature Reading for 24 Hour Period.");
        System.out.println();
        
        for (int hour = 0; hour < hoursPerDay; hour++) {
            
            System.out.print("Enter the temperature reading at " + hour +
                             " hours: ");
            temp = scan.nextInt();
            tempTemporary = temp;
            
            if (hour > 1) {
                if (temp > tempMax) {
                    tempMax = tempTemporary;
                    maxHour = hour;
                }   else if (temp < tempMin) {
                    tempMin = tempTemporary;
                    minHour = hour;
                }   else if ((temp == tempMin) || (temp == tempMax)) {
                    tempMax = tempTemporary;
                    tempMin = tempTemporary;
                    maxHour = hour;
                    minHour = hour;
                }
            }
        }
        
        System.out.println("Maximum temperature in " + maxHour + " : " + tempMax);
        System.out.println("Minimum temperature in " + minHour + " : " + tempMin);
        
        
    }
}
