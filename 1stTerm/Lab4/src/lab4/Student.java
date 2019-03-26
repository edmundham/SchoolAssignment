package lab4;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Student {
        
        Scanner scan = new Scanner(System.in);
        
        private String name;
        private double test1;
        private double test2;
        private double average;
    
        public Student(String studentName) {
            name = studentName;
        }
        
        public void inputGrades() {
            System.out.print("Enter the " + name + "'s 1st score: ");
            test1 = scan.nextDouble();
            System.out.print("Enter the " + name + "'s 2nd score: ");
            test2 = scan.nextDouble();
        }
        
        public double getAverage() {
            return average = (test1 + test2) / 2;
        }
        
        public String getName() {
            return name;
        }
        
        
}
