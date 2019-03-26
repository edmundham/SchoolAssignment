package practice1;

import javax.swing.*;
import java.awt.*;

public class SplatPanel extends JPanel{

    private Circle circle1, circle2, circle3, circle4, circle5;
    
    public SplatPanel() {
    
    circle1 = new Circle(30, Color.red, 70, 35);
    circle2 = new Circle(50, Color.green, 30, 20);
    circle3 = new Circle(100, Color.cyan, 60, 85);
    circle4 = new Circle(45, Color.yellow, 170, 30);
    circle5 = new Circle(60, Color.blue, 200, 60);
    
    setPreferredSize(new Dimension(300, 200));
    setBackground(Color.black);
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        circle1.draw(g);
        circle2.draw(g);
        circle3.draw(g);
        circle4.draw(g);
        circle5.draw(g);
    }
}