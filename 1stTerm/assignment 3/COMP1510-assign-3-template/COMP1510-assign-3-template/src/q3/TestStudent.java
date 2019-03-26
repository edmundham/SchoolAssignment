package q3;

import java.util.Scanner;

/**
 * <p>This is the class that has main method and using Student object.
 * Also, it reads two students' information at the same time, one with name and
 * 3 test scores and the other with test number which user want to enter
 * and that test score.</p>
 *
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class TestStudent {
    
    /**
     * <p>Scanner object scan.</p>
     */
    private static Scanner scan = new Scanner(System.in);
    
    /**
     * <p>String object used for looping do loop.</p>
     */
    private static String again = "r";
    
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        
        // String will be used for reading user input and determine whether
        // to repeat or not
        String againSetScore = "r";
        
        System.out.println("Instruction: Test number must be 1, 2, or 3."
                + "\nOtherwise the results you will see is incorrect.");
        
        // Do loop that contains whole code.
        // It will not be executed again if user input is q
        do {
            
            // Read user input and used for student's first name
            System.out.println("Enter the student's first name: ");
            String firstName = scan.next();
            
            // Read user input and used for student's last name
            System.out.println("Enter the student's last name: ");
            String lastName = scan.next();
            
            // Declare two student object one having all information, and
            // the other have zero parameter
            Student student1 = new Student(firstName, lastName);
            Student student2 = new Student();
            
            // do loop that reads user input and used for declaring
            // second student's test score.
            do {
                
                // Read user input
                System.out.println("Enter the student's test number "
                        + "and the test score with a space:");
                int testNumber = scan.nextInt();
                double testScore = scan.nextDouble();
            
                // Using user input to declare student's test number and score
                student1.setTestScore(testNumber, testScore);
                
                // Ask user to repeat the loop or not and read user input
                System.out.println("You just entered " + testNumber
                        + " test's score: " + student1.getTestScore(testNumber)
                        + "\nDo you want to enter again? If not, enter q"
                        + " otherwise enter any character.\n"
                        + "It should be the same student.");
                againSetScore = scan.next();
                
            } while (!againSetScore.equalsIgnoreCase("q"));
            
            // Declare students average score
            student1.average();
            
            // Can't get student2's average score since
            // average method is limited not to have 0
            // as all tests' scores.
            //student2.average();
            
            // Print students information
            System.out.println(student1);
            System.out.println(student2);
            
            // Ask user to repeat the loop or not and read user input
            System.out.println("Do you want to run this program again?\nIf not,"
                    + " enter q otherwise enter any character.");
            again = scan.next();
            
            
        } while (!again.equalsIgnoreCase("q")); 
        
        
        
    }

};
