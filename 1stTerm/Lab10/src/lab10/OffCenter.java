package lab10;

import javax.swing.*;
import java.awt.*;

public class OffCenter {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Off Cneter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(new OffCenterPanel());
        frame.pack();
        frame.setVisible(true);
    }
    
}
