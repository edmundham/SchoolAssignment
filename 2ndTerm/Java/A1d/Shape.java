package ca.bcit.comp2526.a1d;

/**
 * Shape.java
 * class that contains protected constructor.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public abstract class Shape {
    
    private String[][] table2DArray;
    private final int width;
    private final int height;
    @SuppressWarnings("unused")
    private final String type;
    
    /**
     * Protected Shape constructor.
     * 
     * @param width is width of the shape
     * @param height is height of the shape
     * @param type is type of the shape
     */
    protected Shape(final int width, final int height, final String type) {
        this.width = width;
        this.height = height;
        this.type = type;
        
        // Making a grid.
        table2DArray = new String[this.height][this.width];
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                table2DArray[i][j] = " ";
            }
        }
    }
    
    /**
     * draws diamond using 2d array.
     */
    abstract void draw();
    
    /**
     * prints 2d array which contains shapes with symbols.
     */
    public void display() {
        for (String[] vertical: table2DArray) {
            for (String horizontal: vertical) {
                System.out.print(horizontal);
            }
            System.out.println();
        }        
    }

    /**
     * gets width of the shape.
     * @return width
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * gets height of the shape.
     * @return height
     */
    public int getHeight() {
        return height;
    }
    
    /**
     * get table2DArray.
     * @return table2DArray
     */
    public String[][] getTable2DArray() {
        return table2DArray;
    }
    
}
