package ca.bcit.comp2526.a1d;

/**
 * Rectangle.java
 * Rectangle class that extends Shape class.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Rectangle extends Shape {

    private final int width;
    private final int height;
    private String[][] table2DArray = getTable2DArray();
    
    /**
     * Rectangle constructor that contains width and height.
     * 
     * @param width is the width of the rectangle
     * @param height is the height of the rectangle
     */
    public Rectangle(final int width, final int height) {
        super(width, height, "r");
        this.width = width;
        this.height = height;
        
    }
    
    /**
     * draws Rectangle inside the 2d String array.
     */
    public void draw() {
        
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                table2DArray[i][j] = "*";
            }
        }
        
    }

}
