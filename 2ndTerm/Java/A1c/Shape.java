package ca.bcit.comp2526.a1c;

/**
 * Shape.java
 * class that contains protected constructor.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
abstract class Shape {
    
    private char[][] table2DArray;
    private final int width;
    private final int height;
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
        table2DArray = new char[this.height][this.width];
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                table2DArray[i][j] = ' ';
            }
        }
    }
    
    /**
     * draws the shape.
     */
    abstract void draw();

    /**
     * get width.
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * get height.
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * get type.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * get table2DArray.
     * @return table2DArray
     */
    public char[][] getTable2DArray() {
        return table2DArray;
    }
    
}
