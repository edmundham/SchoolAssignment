package practice1;

import java.awt.*;
import javax.swing.*;

public class Authority {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Authority");
        // title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // x button
        JPanel primary = new JPanel();
        primary.setBackground(Color.yellow);
        primary.setPreferredSize(new Dimension(250, 75));
        // window
        JLabel label1 = new JLabel("Question authority,");
        JLabel label2 = new JLabel("but raise your hand first.");
        // String
        primary.add(label1);
        primary.add(label2);
        // put inside the window
        frame.getContentPane().add(primary);
        frame.pack();
        frame.setVisible(true);
    }
}
