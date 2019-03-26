package lab10;

import java.util.Scanner;

public class Parameters {

    public static void main(String[] args) {
        
        double mean1, mean2;
        int count = 0;
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the numbers with spaces");
        String stringnum = scan.nextLine();
        String[] stringarray = stringnum.split(" ");
        
        for(int i = 0; i < stringarray.length; i++) {
            if (Integer.parseInt(stringarray[i]) < 0) {
                count++;
            }
        }
        
        int[] array = new int[stringarray.length - count];
        
        for(int i = 0; i < stringarray.length; i++) {
            int num = 0;
            if (Integer.parseInt(stringarray[i]) < 0) {
                num++;
            } else {
                array[i - num] = Integer.parseInt(stringarray[i]);
            }
        }
        
        mean1 = average(array);
        mean2 = average(35, 43, 93, 23, 40, 21, 75);
        
        System.out.println("mean1 = " + mean1);
        System.out.println("mean2 = " + mean2);
    }
    
    public static double average(int ... list) {
        double result = 0.0;
        
        if (list.length != 0) {
            int sum = 0;
            for (int num : list) {
                sum += num;
            }
            result = (double) sum / list.length;
        }
        return result;
    }
    
}
