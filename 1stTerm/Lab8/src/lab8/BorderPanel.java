package lab8;

import java.awt.*;
import javax.swing.*;

public class BorderPanel extends JPanel {

    public BorderPanel() {
        
        setLayout(new BorderLayout());
        
        setBackground(Color.green);
        
        JButton b1 = new JButton("Button 1");
        JButton b2 = new JButton("Button 2");
        JButton b3 = new JButton("Button 3");
        JButton b4 = new JButton("Button 4");
        JButton b5 = new JButton("Button 5");
        
        add(b1, BorderLayout.CENTER);
        add(b2, BorderLayout.NORTH);
        add(b3, BorderLayout.SOUTH);
        add(b4, BorderLayout.EAST);
        add(b5, BorderLayout.WEST);
    }
    
}
