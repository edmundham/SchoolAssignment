package q4;

import javax.swing.JFrame;

/**
 * <p>This program will show a traffic light which changes it's color
 * when user click the button in order of green, amber, and red.</p>
 *
 * @author Sunguk (Edmund) Ham, A00979841, Set E
 * @version 1.0
 */
public class TrafficLight {

/**
 * <p>This is the main method.</p>
 *    
 * @param args unused.
 */
    public static void main(String[] args) {
        
        // Setting basic information and action of JFrame
        JFrame frame = new JFrame("Sunguk Ham");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Adding a actual panel to the JFrame
        frame.getContentPane().add(new TrafficLightPanel());
        
        // Sizing the frame and opening in the new window.
        frame.pack();
        frame.setVisible(true);
    }
}
