package practice1;

import javax.swing.JFrame;

public class VoteCoutner {

    public static void main(String[] args) {
    
    JFrame frame = new JFrame("Push Counter");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    frame.getContentPane().add(new PushCounterPanel());
    frame.pack();
    frame.setVisible(true);
    }
}
