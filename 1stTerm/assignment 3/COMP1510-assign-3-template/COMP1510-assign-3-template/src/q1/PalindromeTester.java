package q1;

import java.util.Scanner;

/**
 * <p>This is the modified version of PalindromeTester.java in the textbook
 * called "Java Software Solutions Foundations of Program Design" in chapter 5.
 * The things added are spaces, punctuation, digits, lowercase, and uppercase 
 * will not be considered when the program is determining a string is
 * a palindrome or not.</p>
 *
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class PalindromeTester {
    
    private static boolean isAlpha(char ch) {
        return ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z'); 
    }
    
    /**
     * <p>According to the ASCII table, upper case character
     * starts at 65.</p>
     */
    private static final int MINUPPERCHAR = 65;
    
    /**
     * <p>According to the ASCII table, upper case character
     * ends at 89.</p>
     */
    private static final int MAXUPPERCHAR = 90;
    
    /**
     * <p>According to the ASCII table, lower case character
     * starts at 97.</p>
     */
    private static final int MINLOWERCHAR = 97;
    
    /**
     * <p>According to the ASCII table, lower case character
     * ends at 122.</p>
     */
    private static final int MAXLOWERCHAR = 122;
    
    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        
        // user input palindrome
        String str;
        
        // if y, keep looping
        String another = "y";
        
        // string index number from left
        int left = 0;
        
        // string index number from right
        int right;
        
        Scanner scan = new Scanner(System.in);
        
        // Covers entire code, so that if user inputs
        // y, keep looping, but if user inputs n or another
        // character, stop looping
        while (another.equalsIgnoreCase("y")) {
            
            // user input
            System.out.println("You should enter more than 1 alphabet.");
            System.out.println("Enter a potential palindrome:");
            str = scan.nextLine();
            
            /**
             * Using for loop instead of regular expression
             * 
             * First, cast each character to int. Second, determine whether
             * the int is in the range of Alphabet int in ASCII table.
             * Third, if not, replace that char to dot(.). Fourth,
             * replace dot to empty string, and print a warning message.
             */
            for (int i = 0; i < str.length(); i++) {
                char charCode = str.charAt(i);
                    if (!isAlpha(charCode)) {
                        str = str.replace(charCode, '.');
                        str = str.replace(".", "");
                        System.out.println();
                        System.out.println("You've got punctuations / special "
                                + "characters/numbers in your"
                                + " sentence/words.");
                        System.out.println("This program just ignores"
                                + " the punctuation.");
                    }
            }
            
            // index number starts at the right side of the string
            left = 0;
            right = str.length() - 1;
            
            // Determine whether the input is palindrome or not.
            // Comparing each character from the left to right.
            while (str.charAt(left) == str.charAt(right) && left < right) {
                left++;
                right--;
            }
            
            System.out.println("========================================");
            
            // right is always high if the sentence/word is not palindrome
            if (left < right) {
                System.out.println("That string is NOT a palindrome.");
            }   else {
                    System.out.println("That string IS a palindrome.");
                }
                    
                    // Read user input whether to repeat or not
                    System.out.println();
                    System.out.print("Test another palindrome (y/n)? ");
                    another = scan.nextLine();
                    if (!another.equals("y")
                            && !another.equals("n")) {
                         throw new IllegalArgumentException("You must "
                                 + "enter either y or n");
                    }
        // End of while loop.
        }
        
    }

}
