package ca.bcit.comp2526.a1d;

/**
 * Displayer.java
 * Displayer interface that contains displayshape method.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public interface Displayer {
    
    /**
     * display shapes, and can be overridden by any classes 
     * that implements Displayer interface.
     * @param shape can be any shapes that extends shape class
     */
    void displayShape(Shape shape);
}
