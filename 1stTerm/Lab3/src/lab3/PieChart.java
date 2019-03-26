package lab3;
    import javax.swing.JApplet;
    import java.awt.*;
public class PieChart extends JApplet {
    public void paint(Graphics page) {
        
        setBackground (Color.white);
        page.setColor(getBackground());
        page.fillRect(0, 0, getWidth(), getHeight());
        
        page.setColor(Color.red);
        page.fillArc(100, 100, 500, 500, 90, -126);
        
        page.setColor(Color.blue);
        page.fillArc(100, 100, 500, 500, -36, -54);
        
        page.setColor(Color.black);
        page.fillArc(100, 100, 500, 500, -90, -54);
        
        page.setColor(Color.green);
        page.fillArc(100, 100, 500, 500, -144, -90);
        
        page.setColor(Color.cyan);
        page.fillArc(100, 100, 500, 500, -234, -36);
        
        page.setColor(Color.black);
        page.drawString("Rent and Utilities 35%", 500, 150);
        page.drawString("Transportation 15%", 500, 600);
        page.drawString("Food 15%", 250, 620);
        page.drawString("Educational 25%", 0, 350);
        page.drawString("Miscellaneous 10%", 200, 70);
        
    }
}
