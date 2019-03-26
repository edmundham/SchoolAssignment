package practice1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VoteCounterPanel extends JPanel{
    
    private int count;
    private JButton push;
    private JLabel label;
    
    public VoteCounterPanel() {
        count = 0;
        
        push = new JButton("Push Me!");
        push.addActionListener(new ButtonListener());
        
        label = new JLabel("Pushes: " + count);
        
        add(push);
        add(label);
        
        setPreferredSize(new Dimension(300, 40));
        setBackground(Color.cyan);
    }
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            count++;
            label.setText("Pushes: " + count);
        }
    }
}
