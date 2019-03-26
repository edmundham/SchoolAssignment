package lab4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VoteCounterPanel extends JPanel{
    
    private int countJoe;
    private JButton pushJoe;
    private JLabel labelJoe;
    
    private int countSam;
    private JButton pushSam;
    private JLabel labelSam;
    
    public VoteCounterPanel() {
        countJoe = 0;
        countSam = 0;
        
        pushJoe = new JButton("Joe");
        pushSam = new JButton("Sam");
        
        pushJoe.addActionListener(new JoeButtonListener());
        pushSam.addActionListener(new SamButtonListener());
        
        labelJoe = new JLabel("Voting for Joe: " + countJoe);
        labelSam = new JLabel("Voting for Sam: " + countSam);
        
        add(pushJoe);
        add(pushSam);
        add(labelJoe);
        add(labelSam);
        
        setPreferredSize(new Dimension(200, 70));
        setBackground(Color.cyan);
    }
    
    private class JoeButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            countJoe++;
            labelJoe.setText("Voting for Joe: " + countJoe);
        }
    }
    private class SamButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            countSam++;
            labelSam.setText("Voting for Sam: " + countSam);
        }
    }
    
}
