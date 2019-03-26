package ca.bcit.comp2526.a1d;

/**
 * ConsoleDisplayer.java
 * Draws shapes inside console.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class ConsoleDisplayer implements Displayer {

    /**
     * displays shape inside console.
     * 
     * @param shape can be any shapes that extends shape class
     */
    public void displayShape(final Shape shape) {
        shape.draw();
        shape.display();
        
    }

}
