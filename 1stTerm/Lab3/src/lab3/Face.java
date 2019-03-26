package lab3;
    import javax.swing.JApplet;
    import java.awt.*;
public class Face extends JApplet {
    public void paint(Graphics page) {
        
        final int MID = 100;
        final int TOP = 100;
        
    setBackground (Color.cyan);
    page.setColor(getBackground());
    page.fillRect(0, 0, getWidth(), getHeight());
    
    page.setColor(Color.yellow);
    page.fillOval(MID-30, TOP+140, 60, 60);
    page.fillOval(MID+370, TOP+140, 60, 60);
    
    page.setColor(Color.orange);
    page.fillOval(MID, TOP, 400, 400); //FACE
    
    page.setColor(Color.white);
    page.fillOval(MID+95, TOP+140, 80, 80); //LEFT EYE
    page.fillOval(MID+225, TOP+140, 80, 80); //RIGHT EYE
    
    page.setColor(Color.darkGray);
    page.fillOval(MID+105, TOP+160, 60, 60); //LEFT PUPIL
    page.fillOval(MID+235, TOP+160, 60, 60); //RIGHT PUPIL
    
    page.setColor(Color.black);
    page.fillOval(MID+180, TOP+220, 10, 10); //LEFT NOSE
    page.fillOval(MID+210, TOP+220, 10, 10); //RIGHT NOSE
    
    page.setColor(Color.black);
    page.fillRect(MID+100, TOP+270, 190, 80); //MOUTH
    
    page.setColor(Color.white);
    page.fillRect(MID+140, TOP+270, 55, 30); //LEFT TEETH
    page.fillRect(MID+200, TOP+270, 55, 30); //RIGHT TEETH
    
    page.setColor(Color.red);
    page.fillRect(MID+150, TOP+320, 95, 30); //TONGUE
    
        }
    }
