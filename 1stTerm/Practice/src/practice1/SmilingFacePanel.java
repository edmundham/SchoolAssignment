package practice1;

import javax.swing.JPanel;
import java.awt.*;

public class SmilingFacePanel extends JPanel{
    
    public final int BASEX = 120, BASEY = 60;
    
    public SmilingFacePanel() {
        setBackground(Color.blue);
        setPreferredSize(new Dimension(320, 200));
        setFont(new Font("Arial", Font.BOLD, 16));
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.yellow);
        g.fillOval(BASEX, BASEY, 80, 80); //head
        g.fillOval(BASEX-5, BASEY+20, 90, 40);
        
        g.setColor(Color.black);
        g.drawOval(BASEX+20, BASEY+30, 15, 7);
        g.drawOval(BASEX+45, BASEY+30, 15, 7);
        
        g.fillOval(BASEX+25, BASEY+31, 5, 5);
        g.fillOval(BASEX+50, BASEY+31, 5, 5);
        
        g.drawArc(BASEX+20, BASEY+25, 15, 7, 0, 180);
        g.drawArc(BASEX+45, BASEY+25, 15, 7, 0, 180);
        
        g.drawArc(BASEX+35, BASEY+40, 15, 10, 180, 180);
        g.drawArc(BASEX+20, BASEY+50, 40, 15, 180, 180);
        
        g.setColor(Color.white);
        g.drawString("Always remember that you are unique!", BASEX-105, BASEY-15);
        g.drawString("Just like everyone else.", BASEX-45, BASEY+105);
    }
}
