package lab3;

// **************************************************************
//  Colors.java
//
//  Draw rectangles to illustrate colors and their codes in Java
// **************************************************************

import javax.swing.JApplet;
import java.awt.*;

public class Colors extends JApplet{
    public void paint (Graphics page) {
        
        //Declare size constants
        final int PAGE_WIDTH = 600;
        final int PAGE_HEIGHT = 400;
        
        //Declare variables
        int x, y;   // x and y coordinates of upper left-corner of each shape
        int width, height; // width and height of each shape
        int redCode, greenCode, blueCode;
        
        Color myColor = new Color (2486921);
        
        // Set the background Color and paint the screen with a white rectangle
        setBackground(Color.white);
        page.setColor(Color.white);
        page.fillRect(0, 0, PAGE_WIDTH, PAGE_HEIGHT);
        
        // Set the color for the rectangle
        page.setColor(myColor);
        
        // Assign the corner point and width and height then draw
        x = 200;
        y = 125;
        width = 200;
        height = 150;
        
        page.fillRect(x, y, width, height);
        
        redCode = myColor.getRed();
        page.setColor(Color.white);
        page.drawString("Red: " + redCode, x, y + 10);
        
        greenCode = myColor.getGreen();
        page.drawString("Green: " + greenCode, x, y + 85);
        
        blueCode = myColor.getBlue();
        page.drawString("Blue: " + blueCode, x, y + 150);
    }
}
