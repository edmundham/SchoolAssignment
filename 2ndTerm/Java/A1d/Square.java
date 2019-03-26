package ca.bcit.comp2526.a1d;

/**
 * Square.java
 * Square class that extends Rectangle, using same width and height.
 * 
 * @author ham2959
 * @version 1.0
 */
public class Square extends Rectangle {

    /**
     * Rectangle constructor that contains width and height.
     * 
     * @param width is the width of the rectangle
     * @param height is the height of the rectangle
     */
    public Square(final int width, final int height) {
        super(width, width);
    }
}
