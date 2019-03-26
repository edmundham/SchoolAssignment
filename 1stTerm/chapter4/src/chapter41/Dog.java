package chapter41;
    
    import java.util.*;
    
public class Dog {

    Scanner scan = new Scanner(System.in);
    
    private String name;
    private int age;
    private int calAge;
    
    public Dog() {
        
    }
    
    public void setinfo() {
        System.out.print("Enter your dog's name: ");
        name = scan.next();
        System.out.print("Enter your dog's age: ");
        age = scan.nextInt();
    }
    
    public int getAge() {
        calAge = 7 * age;
        return calAge;
    }
    
    public String toString() {
        return "This is your dog's age which is equivalent with human age: "
                + calAge;
    }
    
}
