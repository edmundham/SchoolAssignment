package ca.bcit.comp2526.a1a;

/**
 * A program that prints out the multiplication or addition table given
 * the user's start and end range and type of table.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class ArithmeticTable {

    /**
     * Table type enum consisting of Multiplication and addition.
     * 
     * @author Sunguk (Edmund) Ham, A00979841
     * @version 1.0
     */
    private enum TableType {
        MULT, ADD
    };
    
    /**
     * Type of table represents Addition or Multiplication.
     */
    private TableType userTableType;
    
    /**
     * Start number using in the table which user inputs.
     */
    private int start;
    
    /**
     * End number using in the table which user inputs.
     */
    private int end;
    
    /**
     * 2D Array of table.
     */
    private double[][] table2DArray;
    
    /**
     * Check the user input whether it's valid or not.
     * 
     * @param args read user input
     * @return true if user input is valid
     */
    public boolean argumentCheck(String[] args) {
        
        // To avoid checkstyle error
        // 3 for argument length
        // 100 for the biggest number for table row and columns
        final int argumentLength = 3;
        final int maxNumber = 100;
        
        if (args.length != argumentLength) {
            System.err.print("Usage: Main <type> <start> <stop>\n"
                    + "\tWhere <type> is one of +, \"*\"\n"
                    + "\tand <start> is between 1 and 100\n"
                    + "\tand <stop> is between 1 and 100\n"
                    + "\tand start < stop");
            return false;
        }        

        if (args[0].charAt(0) == '+') {
            userTableType = TableType.ADD;
        } else {    
            userTableType = TableType.MULT;
        }
        
        // start number and end number
        int sta;
        int sto;

        try {
            sta = Integer.parseInt(args[1]);
            sto = Integer.parseInt(args[2]);
        } catch (NumberFormatException ex) {
            System.err.print("Usage: Main <type> <start> <stop>\n"
                    + "\tWhere <type> is one of +, \"*\"\n"
                    + "\tand <start> is between 1 and 100\n"
                    + "\tand <stop> is between 1 and 100\n"
                    + "\tand start < stop");
            return false;
        }

        if ((sta < 1 || sta > maxNumber) || ((sto < 1 || sto > maxNumber))) {
            System.err.print("Usage: Main <type> <start> <stop>\n"
                    + "\tWhere <type> is one of +, \"*\"\n"
                    + "\tand <start> is between 1 and 100\n"
                    + "\tand <stop> is between 1 and 100\n"
                    + "\tand start < stop");
            return false;
        }

        if (sta > sto) {
            System.err.print("Usage: Main <type> <start> <stop>\n"
                    + "\tWhere <type> is one of +, \"*\"\n"
                    + "\tand <start> is between 1 and 100\n"
                    + "\tand <stop> is between 1 and 100\n"
                    + "\tand start < stop");
            return false;
        }
      
        start = sta;
        end = sto;
        return true;
    }
    
    /**
     * Creates multiplication or addition table.
     * 
     * @param begin is a start number
     * @param finish is a end number
     * @param tableType is a table type ADD or MULT
     */
    public void createTable(int begin, int finish, TableType tableType) {
        this.start = begin;
        this.end = finish;
        this.userTableType = tableType;
        
        // 2D array[][]
        table2DArray = new double[end - start + 1][end - start + 1];
        
        if (userTableType == TableType.ADD) {
            // double for loop 0 to array.length - 1
            for (int i = 0; i < (end - start + 1); i++) {
                for (int j = 0; j < (end - start + 1); j++) {
                    // addition table
                    table2DArray[i][j] = (start + i) + (start + j);
                }
            }
        } else {
            for (int i = 0; i < (end - start + 1); i++) {
                for (int j = 0; j < (end - start + 1); j++) {
                    // multiplication table
                    table2DArray[i][j] = (start + i) * (start + j);
                }
            }
        }
    }
    
    /**
     * Prints the formatted table.
     */
    public void printTable() {
        
        char sign;
        
        if (userTableType == TableType.ADD) {
            sign = '+';
        } else {
            sign = '*';
        }
        
        // save for using row numbers
        int tempVarForStart = start;
        
        // for formatting
        String spaces = "";
        String dashes = "------";
        
        // printf sign + table2DArray index 0 to end
        // + n n n n n n n n n
        System.out.printf("%5s", sign);
        for (int i = 0; i < table2DArray[0].length; i++) {
            System.out.printf("%6d", start++);
        }
        System.out.printf("\n");
        
        // printf spaces + five-s times of table2DArray.length \n
        //    ------------------
        System.out.printf("%5s", spaces);
        for (int i = 0; i < table2DArray[0].length; i++) {
            System.out.printf("%6s", dashes);
        }
        System.out.printf("\n");
        
        // set start again
        start = tempVarForStart;
        
        // n | n n n n n n n n
        for (int i = 0; i < table2DArray[0].length; i++) {
            System.out.printf("%3d%1s", start++, spaces);
            System.out.printf("|");
            for (int j = 0; j < table2DArray[0].length; j++) {
                // 6 spaces because of formatting
                System.out.printf("%6.0f", table2DArray[i][j]);
            }
            System.out.printf("\n");
        }
        
        
    }
    
    /**
     * Main method.
     * 
     * @param args used for checking + or *, and start and end number
     */
    public static void main(String[] args) {
        ArithmeticTable table = new ArithmeticTable();
        
        if (table.argumentCheck(args)) {
            table.createTable(table.start, table.end, table.userTableType);
            table.printTable();
        }
    }
}
