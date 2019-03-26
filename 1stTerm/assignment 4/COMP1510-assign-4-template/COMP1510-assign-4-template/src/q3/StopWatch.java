package q3;

import javax.swing.JFrame;

/**
 * <p>This program has simple main method which contains
 * JFrame object and call StopWatchPanel.</p>
 *
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class StopWatch {
    /**
     * <p>This is the main method (entry point) 
     * that gets called by the JVM.</p>
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sunguk Ham");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Adding StopWatchPanel
        frame.getContentPane().add(new StopWatchPanel());
        
        frame.pack();
        frame.setVisible(true);
    }

};
