package practice1;
    
    import java.util.Scanner;
    import java.util.Random;
    
public class PP1 {
    public static void main(String[] args) {
        
        String firstName;
        String lastName;
        char firstfirstName;
        String fivelastName;
        int random;
        
        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
        
        System.out.print("Write your first name: ");
            firstName = scan.nextLine();
        System.out.print("Write your last name: ");
            lastName = scan.nextLine();
        
        firstfirstName = firstName.charAt(0);
        fivelastName = lastName.substring(0, 5);
        
            random = generator.nextInt(90) + 10;
        
        System.out.println(firstfirstName + fivelastName);
        System.out.println(random);
        
    }
}
