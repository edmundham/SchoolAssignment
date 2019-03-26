package ca.bcit.comp2526.a1b;

/**
 * Main.java
 * Main class drives the program.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Main {
    
    /**
     * Drives the program.
     * @param argv arguments
     */
    public static void main(final String[] argv) {
        final TableType type;
        final int start;
        final int stop;
        final int maxNum = 3;
        
        if (argv.length != maxNum) {
            usage();
        }

        type  = getType(argv[0]);
        start = getNumber(argv[1]);
        stop  = getNumber(argv[2]);
        
        displayTable(type, start, stop);
    }
    
    /**
     * Returns the TableType represented by the specified String.
     * @param str the table type
     * @return TableType
     */
    public static TableType getType(final String str) {
        final TableType type;
        
        if (str.equals("+")) {
            type = TableType.ADD;
        } else if (str.equals("*")) {
            type = TableType.MULT;
        } else {
            usage();
            type = null;
        }
        
        return (type);
    }
    
    /**
     * Returns the number contained in the specified String.
     * @param str contains a number
     * @return number as an int
     */
    public static int getNumber(final String str) {
        int val;
        final int maxVal = 100;
        
        try {
            val = Integer.parseInt(str);
            
            if (val < 1 || val > maxVal) {
                usage();
            }
        } catch (NumberFormatException ex) {
            usage();
            val = 0;
        }
        
        return (val);
    }
    
    /**
     * Displays a table with the specified bounds using
     * the specified TableType (operation).
     * @param type of operation
     * @param start upper bound
     * @param stop lower bound
     */
    public static void displayTable(final TableType type,
                                    final int start,
                                    final int stop) {
        // PUT YOUR CODE HERE
        AdditionTable addTable = new AdditionTable(start, stop);
        MultiplicationTable multTable = new MultiplicationTable(start, stop);
        
        if (type == TableType.ADD) {
            addTable.display();
        } else {
            multTable.display();
        }
    }    
    
    /**
     * Prints a program usage message to the console.
     */
    public static void usage() {
        System.err.println("Usage: Main <type> <start> <stop>");
        System.err.println("\tWhere <type> is one of +, \"*\"");
        System.err.println("\tand <start> is between 1 and 100");
        System.err.println("\tand <stop> is between 1 and 100");
        System.err.println("\tand start < stop");
        System.exit(1);
    }            
}
