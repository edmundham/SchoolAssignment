package lab1;

public class PlusTest {
    // -----------------------------------------------------------------
    //  
    //  main prints some expressions using the + operator
    //
    // -----------------------------------------------------------------
    public static void main (String[] args) {
        System.out.println ("This is a long string that is the " + 
                "concatenation of two shorter strings.");
        System.out.println ("The first computer was invented about " + 55 +
                " years ago.");
        System.out.println ("8 plus 5 is " + 8 + 5); /*
        If at least one operand is a string the other operand is converted to a string
        and + is the concatenation operator.
        */
        System.out.println ("8 plus 5 is " + (8 + 5)); /*
        expression with parentheses
        */
        System.out.println (8 + 5 + " equals 8 plus 5."); /*
        both operands are numbers
        */
    }
}
