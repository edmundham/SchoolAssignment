package ca.bcit.comp2526.a1b;

/**
 * MultiplicationTable.java
 * MultiplicationTable class that contains a constructor, 
 * creatTable method, and display method.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class MultiplicationTable {
    
    /**
     * int start that indicates start number of multiplication table.
     */
    private int start;
    
    /**
     * int end that indicates end number of multiplication table.
     */
    private int end;
    
    /**
     * 2D int array that contains elements of the table.
     */
    private int[][] table2DArray;
    
    // (plan)constructor that accepts start, end
    /**
     * MultiplicationTable constructor that has start number, end number.
     * 
     * @param start is start number of multiplication
     * @param end is end number of multiplication
     */
    public MultiplicationTable(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    // (plan)createTable method that create table
    /**
     * createTable method creates a table in to 2D array.
     */
    private void createTable() {
        table2DArray = new int[end - start + 1][end - start + 1];
     
        for (int i = 0; i < table2DArray[0].length; i++) {
            for (int j = 0; j < table2DArray[0].length; j++) {
                table2DArray[i][j] = (start + i) * (start + j);
            }
        }        
    }
    
    // (plan)display method that prints the table looks like
    // * n n n
    //  ------
    // n|n n n
    // n|n n n
    /**
     * display method that prints the formatted table.
     */
    public void display() {
        int tempVarForStart = start;
        final String spaces = "";
        final String dashes = "------";
        final String multi = "*";
        
        createTable();
        
        //(plan)first line
        System.out.printf("%5s", multi);
        for (int i = 0; i < table2DArray[0].length; i++) {
            System.out.printf("%6d", start++);
        }
        System.out.printf("\n");
        start = tempVarForStart;
        
        //(plan)second line
        System.out.printf("%5s", spaces);
        for (int i = 0; i < table2DArray[0].length; i++) {
            System.out.printf("%6s", dashes);
        }
        System.out.printf("\n");
        
        //(plan)start table
        for (int i = 0; i < table2DArray[0].length; i++) {
            System.out.printf("%3d%1s", start++, spaces);
            System.out.printf("|");
            for (int j = 0; j < table2DArray[0].length; j++) {
                // (plan)6 spaces because of formatting
                System.out.printf("%6d", table2DArray[i][j]);
            }
            System.out.printf("\n");
        }
    }

}
