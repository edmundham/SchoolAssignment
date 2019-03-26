package lab4;

import javax.swing.*;
import java.awt.*;

public class DrawSquares extends JApplet {
    
    static Square square1 = new Square();
    Square square2 = new Square();
    Square square3 = new Square();
    Square square4 = new Square();
    Square square5 = new Square();
    
    public void paint(Graphics g) {
        
        square1.draw(g);
        square2.draw(g);
        square3.draw(g);
        square4.draw(g);
        square5.draw(g);
        
    }
}
