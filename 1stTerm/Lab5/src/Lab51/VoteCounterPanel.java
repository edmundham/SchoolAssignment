package Lab51;

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
    private JLabel labelWinning;
    
    public VoteCounterPanel() {
        countJoe = 0;
        countSam = 0;
        
        pushJoe = new JButton("Joe");
        pushSam = new JButton("Sam");
        
        pushJoe.addActionListener(new ButtonListener());
        pushSam.addActionListener(new ButtonListener());
        
        labelJoe = new JLabel("Voting for Joe: " + countJoe);
        labelSam = new JLabel("Voting for Sam: " + countSam);
        labelWinning = new JLabel("No one is winning.");
        
        add(pushJoe);
        add(pushSam);
        add(labelJoe);
        add(labelSam);
        add(labelWinning);
        
        setPreferredSize(new Dimension(220, 80));
        setBackground(Color.cyan);
    }
    
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            
            if (event.getSource() == pushJoe) {
            countJoe++;
            labelJoe.setText("Voting for Joe: " + countJoe);
            }   else if (event.getSource() == pushSam) {
                countSam++;
                labelSam.setText("Voting for Sam: " + countSam);
            }
            
            if (countJoe > countSam) {
                labelWinning.setText("Joe is winning.");
            }   else if (countJoe < countSam) {
                labelWinning.setText("Sam is winning.");
            }   else {
                labelWinning.setText("No one is winning.");
            }
            
            
        }
    }
    
}
