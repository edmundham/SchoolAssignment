package ca.bcit.comp2526.a1d;

/**
 * RTriangle.java
 * RTriangle that extends shape and has draw method.
 * 
 * @author ham2959
 * @version 1.0
 */
public class RTriangle extends Shape {

    @SuppressWarnings("unused")
    private final int width;
    private final int height;
    private String[][] table2DArray = getTable2DArray();
    
    /**
     * RTriangle constructor that contains width and height. 
     * Initialize table2DArray.
     * 
     * @param width is the width of the Rtriangle
     * @param height is the height of the Rtriangle
     * @throws BadWidthException if width is even number
     */
    public RTriangle(final int width, final int height)
            throws BadWidthException {
        super(width / 2 + 1, (width / 2) + 1, "t");
        this.width = width / 2;
        this.height = (width / 2) + 1;
        
        if (width % 2 == 0) {
            throw new BadWidthException();
        }
        
        
    }
    
    /**
     * draws RTriangle in the 2d String array.
     */
    public void draw() {
        // table2DArray is currently filled with white spaces
        // fill @ in certain slots
        //
        // if user input is 7
        // i 0 to 3
        // i 0 then j 3
        // i 1 then j 2,3
        // i 2 then j 1,2,3
        // i 3 then j 0,1,2,3
        //
        // i goes 0 to height - 1
        // j starts height - 1 - i to height + i - 1
        for (int i = 0; i < this.height; i++) {
            for (int j = this.width - i; j <= this.width; j++) {
                table2DArray[i][j] = "@";
            }
        }
    }

}
