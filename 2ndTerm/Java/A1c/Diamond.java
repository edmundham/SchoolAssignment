package ca.bcit.comp2526.a1c;

/**
 * Diamond.java
 * Diamond class that extends Shape class.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Diamond extends Shape {

    private final int width;
    private final int height;
    private final int changingPoint;
    private char[][] table2DArray = getTable2DArray();

    /**
     * Diamond constructor that contains width and height.
     * 
     * @param width is the width of the Diamond
     * @param height is the height of the Diamond
     * @throws BadWidthException if width is even number
     */
    public Diamond(final int width, final int height) 
            throws BadWidthException {
        super(width, width, "d");
        this.width = width;
        this.height = width;
        
        if (width % 2 == 0) {
            throw new BadWidthException();
        }
        
        // table2DArray is currently filled with white spaces
        // fill # in certain slots
        //
        // if user input is 7
        // i 0 to 6
        // i 0 then j 3
        // i 1 then j 2,3,4
        // i 2 then j 1,2,3,4,5
        // i 3 then j 0,1,2,3,4,5,6
        // i 4 then j 1,2,3,4,5
        // i 5 then j 2,3,4
        // i 6 then j 3
        //
        // i goes 0 to height - 1
        // changing point is width / 2 = 3
        //
        // i is less than or equal to 3,
        // j goes changingPoint - i to changingPoint + i
        // i is greater than 3, 
        // j goes i - changingPoint to width - i + changingPoint - 1
        changingPoint = this.width / 2;
        for (int i = 0; i < this.height; i++) {
            if (i <= changingPoint) {
                for (int j = changingPoint - i;
                        j < changingPoint + i + 1;
                        j++) {
                    table2DArray[i][j] = '#';
                }
            }
            if (i > changingPoint) {
                for (int j = i - changingPoint;
                        j < this.width + changingPoint - i;
                        j++) {
                    table2DArray[i][j] = '#';
                }
            }
        }
        
    }

    /**
     * draws diamond using 2d array.
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
