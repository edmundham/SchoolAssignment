package ca.bcit.comp2526.a1d;

import javax.swing.JFrame;

/**
 * SwingDisplayer.java
 * the class calls displayerFrame which extends JFrame.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class SwingDisplayer implements Displayer {
    
    /**
     * displays shape in the JFrame.
     * 
     * @param shape can be any shapes that extends shape class
     */
    public void displayShape(final Shape shape) {
        final DisplayerFrame frame;

        frame = new DisplayerFrame();
        frame.init(shape);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
