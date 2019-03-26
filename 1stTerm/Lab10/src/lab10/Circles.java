package lab10;

import javax.swing.JFrame;

public class Circles {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Circles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(new CirclePanel());
        
        frame.pack();
        frame.setVisible(true);
    }
    
}
