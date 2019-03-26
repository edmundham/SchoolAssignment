package lab6;

import java.util.Scanner;

public class Dates {

    public static void main(String[] args) {
    
    int month, day, year;       //date read in from user
    int daysInMonth=0;            //number of days in month read in
    // true if input from user is valid
    boolean monthValid=false, yearValid=false, dayValid=false;
    boolean leapYear=false;           //true if user's year is a leap year
    
    Scanner scan = new Scanner(System.in);
    
    //Get integer month, day, and year from user
    System.out.print("Enter the month, day, and year with a"
            + " space in a number:");
    month = scan.nextInt();
    day = scan.nextInt();
    year = scan.nextInt();
    //check to see if month is valid
    if ((month >= 1) && (month <= 12)) {
        monthValid = true;
    }   else {
        monthValid = false;
        }
    
    
    //check to see if year is valid
    if ((year >= 1000) && (year <= 1999)) {
        yearValid = true;
    }   else {
            yearValid = false;
        }
    
    //determine whether it's a leap year
    
    if (year % 400 == 0) {
        leapYear = true;
        }   if ((year % 4 == 0) && !(year % 100 == 0)) {
            leapYear = true;
        }
    //determine number of days in month
    if (monthValid&&(month == 2)) {
        daysInMonth = 28;
    }   else if (monthValid&&(month % 2 == 1)&&(month <= 7)) {
        daysInMonth = 31;
    }   else if (monthValid&&(month % 2 == 0)&&(month >= 8)) {
        daysInMonth = 31;
    }   else if (monthValid&&(month % 2 == 0)&&(month <= 7)) {
        daysInMonth = 30;
    }   else if (monthValid&&(month % 2 == 1)&&(month >= 8)) {
        daysInMonth = 30;
    }   if (monthValid&&leapYear&&(month == 2)) {
        daysInMonth = 29;
    }
    //user number of days in month to check to see if day is valid
    if (daysInMonth == day) {
        dayValid = true;
    }   else {
        dayValid = false;
    }
    //determine whether date is valid and print appropriate message
    if (dayValid&&monthValid&&yearValid) {
        System.out.print("Date is valid.");
        if (leapYear) {
            System.out.println(" Also, it's a leap year.");
    }
    
    } else {
        System.out.println("Date is invalid.");
    }
    }
    
}
