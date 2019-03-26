package lab10;

import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class DotsPanel extends JPanel {
    
    private final int SIZE = 6;
    
    private ArrayList<Point> pointList;
    
    public DotsPanel() {
        pointList = new ArrayList<Point>();
        
        addMouseListener(new DotsListener());
        
        setBackground(Color.black);
        setPreferredSize(new Dimension(300, 200));
    }
    
    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        
        page.setColor(Color.green);
        
        for (Point spot : pointList) {
            page.fillOval(spot.x-SIZE, spot.y-SIZE, SIZE * 2, SIZE * 2);
        }
        
        page.drawString("Count: " + pointList.size(), 5, 15);
    }
    
    private class DotsListener implements MouseListener {
        
        public void mousePressed(MouseEvent event) {
            pointList.add(event.getPoint());
            repaint();
        }
        
        public void mouseClicked(MouseEvent event) {}
        public void mouseEntered(MouseEvent event) {}
        public void mouseExited(MouseEvent event) {}
        public void mouseReleased(MouseEvent event) {}
        
    }
}
