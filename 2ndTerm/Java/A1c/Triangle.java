package ca.bcit.comp2526.a1c;

/**
 * Triangle.java
 * Triangle class that extends Shape class.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Triangle extends Shape {

    @SuppressWarnings("unused")
    private final int width;
    private final int height;
    private char[][] table2DArray = getTable2DArray();
    
    /**
     * Triangle constructor that contains width and height. 
     * Initialize table2DArray.
     * 
     * @param width is the width of the triangle
     * @param height is the height of the triangle
     * @throws BadWidthException if width is even number
     */
    public Triangle(final int width, final int height)
            throws BadWidthException {
        super(width, (width / 2) + 1, "t");
        this.width = width;
        this.height = (width / 2) + 1;
        
        if (width % 2 == 0) {
            throw new BadWidthException();
        }
        
        // table2DArray is currently filled with white spaces
        // fill @ in certain slots
        //
        // if user input is 7
        // i 0 to 3
        // i 0 then j 3
        // i 1 then j 2,3,4
        // i 2 then j 1,2,3,4,5
        // i 3 then j 0,1,2,3,4,5,6
        //
        // i goes 0 to height - 1
        // j starts height - 1 - i to height + i - 1
        for (int i = 0; i < this.height; i++) {
            for (int j = this.height - 1 - i; j < this.height + i; j++) {
                table2DArray[i][j] = '@';
            }
        }
    }

    /**
     * draws triangle using 2d array.
     */
    public void draw() {
        for (char[] vertical: table2DArray) {
            for (char horizontal: vertical) {
                System.out.print(horizontal);
            }
            System.out.println();
        }
    }

}
