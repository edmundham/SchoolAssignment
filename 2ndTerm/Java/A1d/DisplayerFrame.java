package ca.bcit.comp2526.a1d;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * DisplayerFrame.java
 * DisplayerFrame class that extends JFrame 
 * gets 2D String array and add into the button.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class DisplayerFrame extends JFrame {
    
    /**
     * To avoid eclipse warnings.
     */
    private static final long serialVersionUID = 870554198171668917L;
    
    private JButton[][] button2DArray;
    
    /**
     * initialize JFrame with buttons inside.
     * @param shape can be any shapes that extends shape class
     */
    public void init(final Shape shape) {
        shape.draw();
        String[][] table2DArray = shape.getTable2DArray();
        
        // code to create a grid layout with buttons that will display the
        // shape
        // initialize button array
        button2DArray = new JButton[shape.getHeight()][shape.getWidth()];
        // check the shape.table2Darray
        for (int i = 0; i < table2DArray.length; i++) {
            for (int j = 0; j < table2DArray[0].length; j++) {
                    // initialize each buttons in the button array
                    button2DArray[i][j] = new JButton(table2DArray[i][j]);
                    // add buttons to the frame
                    add(button2DArray[i][j]);
            }
        }
        
        // set layout
        setLayout(new GridLayout(button2DArray.length,
                button2DArray[0].length));
        
    }
}
