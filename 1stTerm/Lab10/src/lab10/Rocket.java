package lab10;

import javax.swing.JFrame;

public class Rocket {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Rocket");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        RocketPanel panel = new RocketPanel();
        
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    
}
