package lab4;

import java.util.Scanner;

public class TestNames {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String firstName1;
        String secondName1;
        String lastName1;
        String firstName2;
        String secondName2;
        String lastName2;
        
        System.out.print("Enter your full name in order of first, second, and last: ");
        firstName1 = scan.next();
        secondName1 = scan.next();
        lastName1 = scan.next();
        
        Name person1 = new Name(firstName1, secondName1, lastName1);
        
        System.out.print("Enter another full name in order of first, second, and last: ");
        firstName2 = scan.next();
        secondName2 = scan.next();
        lastName2 = scan.next();
        
        Name person2 = new Name(firstName2, secondName2, lastName2);
        
        System.out.println("Human1: " + person1.firstMiddleLast());
        System.out.println("Human2: " + person2.firstMiddleLast());
        
        System.out.println("Human1: " + person1.lastFirstMiddle());
        System.out.println("Human2: " + person2.lastFirstMiddle());
        
        System.out.println("Human1: " + person1.initials());
        System.out.println("Human2: " + person2.initials());
        
        System.out.println("Human1: " + person1.length());
        System.out.println("Human2: " + person2.length());
        
        System.out.println("Human1 == Human2: " + person1.equal(person2));
        
    }
}
