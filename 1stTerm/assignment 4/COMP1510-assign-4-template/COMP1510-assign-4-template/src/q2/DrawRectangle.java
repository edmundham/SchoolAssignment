package q2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <p>This program will draw a rectangle, and its size is determined by
 * a mouse drag.</p>
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class DrawRectangle extends JFrame {
    
    /**
     * <p>Constant is used for setting frame width and height.</p>
     */
    private static final int FRAME = 400;
    
    /**
     * <p>The constructor that makes JFrame.</p>
     */
    public DrawRectangle() {
        super("Sunguk Ham");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new DrawRectanglePanel());
        setSize(FRAME, FRAME);
        setVisible(true);
    }

    /**
     * <p>JPanel contains drawing panel and implements two listener 
     * related to the mouse and mouse motion.</p>
     */
    private class DrawRectanglePanel extends JPanel implements MouseListener,
            MouseMotionListener {
        
        /**
         * <p>Point object that is used to the pivot.</p>
         */
        private Point point1;
        
        /**
         * <p>Point object that is used to the point following 
         * the mouse motion.</p>
         */
        private Point point2;
        
        /**
         * <p>The constructor adds two interface and sets 
         * background color.</p>
         */
        DrawRectanglePanel() {
            addMouseListener(this);
            addMouseMotionListener(this);
            setBackground(Color.black);
        }

        /**
         * <p>Paint methods using two point objects.</p>
         * 
         * @param g is a paint component
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.setColor(Color.cyan);
            //Logics
            //4 different if statement if mouse cursor goes
            //right-top, right-bottom, left-top, and left-bottom
            //If square doesn't have width or height, it won't show up.
            if (point1 != null || point2 != null) {
                //right-bottom
                if (point1.x < point2.x && point1.y < point2.y) {
                    g.fillRect(point1.x, point1.y, 
                            point2.x - point1.x, point2.y - point1.y);
                }
                //left-top
                if (point2.x < point1.x && point2.y < point1.y) {
                    g.fillRect(point2.x, point2.y, point1.x - point2.x,
                            point1.y - point2.y);
                }
                //right-top
                if (point1.x < point2.x && point2.y < point1.y) {
                    g.fillRect(point1.x, point2.y, 
                            point2.x - point1.x, point1.y - point2.y);
                }
                //left-bottom
                if (point2.x < point1.x && point1.y < point2.y) {
                    g.fillRect(point2.x, point1.y, 
                            point1.x - point2.x, point2.y - point1.y);
                }
            }
        }

        /**
         * <p>The method used for set pivot point of the rectangle.</p>
         * 
         * @param e is used for setting point object point1
         */
        public void mousePressed(MouseEvent e) {
            point1 = e.getPoint();
        }

        /**
         * <p>The method used for setting the point that 
         * follows mouse motion, and repainting whenever mouse change
         * its location.</p>
         * 
         * @param e is used for setting point object point2
         */
        public void mouseDragged(MouseEvent e) {
            point2 = e.getPoint();
            repaint();
        }
        
        /**
         * <p>Method is in the interface, but the program do not need
         * this method.</p>
         * 
         * @param e unused
         */
        public void mouseReleased(MouseEvent e) {
            
        }
        
        /**
         * <p>Method is in the interface, but the program do not need
         * this method.</p>
         * 
         * @param e unused
         */
        public void mouseEntered(MouseEvent e) {
            
        }
        
        /**
         * <p>Method is in the interface, but the program do not need
         * this method.</p>
         * 
         * @param e unused
         */
        public void mouseExited(MouseEvent e) {
            
        }
        
        /**
         * <p>Method is in the interface, but the program do not need
         * this method.</p>
         * 
         * @param e unused
         */
        public void mouseClicked(MouseEvent e) {
            
        }
        
        /**
         * <p>Method is in the interface, but the program do not need
         * this method.</p>
         * 
         * @param e unused
         */
        public void mouseMoved(MouseEvent e) {
            
        }

    }

    /**
     * <p>This is the main method (entry point) that gets called by the JVM.</p>
     *
     * @param args unused.
     */
    public static void main(String[] args) {
        new DrawRectangle();
    }

};
