package lab4;

import java.util.Random;
import javax.swing.*;

import org.w3c.dom.css.RGBColor;

import java.awt.*;

public class Square {
    
    private static Random generator = new Random();
    
    private int size;
    private int x;
    private int y;
    private int color;
    
    public Square() {
        size = generator.nextInt(101) + 100;
        x = generator.nextInt(601);
        y = generator.nextInt(401);
        color = generator.nextInt(16777215);
        //String stringcolor = Integer.toBinaryString(color);
        //color = Integer.parseInt(stringcolor);
    }
    
    public void draw(Graphics g) {        
        Color rgbcolor = new Color(color);
        g.setColor(rgbcolor);
        g.fillRect(x, y, size, size); 
    }
}
