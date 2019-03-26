package lab10;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class OffCenterPanel extends JPanel{

    private final int width = 300, height = 300;
    private DecimalFormat fmt;
    private Point current;
    private int centerX, centerY;
    private double length;
    
    public OffCenterPanel() {
        addMouseListener(new OffCenterListener());
        
        centerX = width / 2;
        centerY = height / 2;
        
        fmt = new DecimalFormat("0.##");
        
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.yellow);
    }
    
    public void paintComponent(Graphics p) {
        super.paintComponent(p);
        p.setColor(Color.black);
        p.drawOval(centerX-3, centerY-3, 6, 6);
        
        if(current != null) {
            p.drawLine(current.x, current.y, centerX, centerY);
            p.drawString("Distance: " + fmt.format(length), 10, 15);
        }
    }
    
    private class OffCenterListener extends MouseAdapter {
        public void mouseClicked(MouseEvent event) {
            current = event.getPoint();
            length = Math.sqrt(Math.pow((current.x-centerX), 2) +
                    Math.pow((current.y-centerY), 2));
            repaint();
        }
    }
    
}
