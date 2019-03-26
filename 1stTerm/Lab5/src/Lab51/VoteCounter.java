package Lab51;

import javax.swing.JFrame;

public class VoteCounter {

    public static void main(String[] args) {
    
    JFrame frame = new JFrame("Push Counter");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.getContentPane().add(new VoteCounterPanel());
    frame.pack();
    frame.setVisible(true);
    }
}
