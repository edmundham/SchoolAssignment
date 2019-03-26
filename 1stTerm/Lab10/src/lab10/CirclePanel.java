package lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CirclePanel extends JPanel {

    private final int WIDTH = 600, HEIGHT = 400;

    private Circle circle;
    
    //-------------------------------------------------------------------
    // Sets up this panel to listen for mouse events.
    //-------------------------------------------------------------------
    public CirclePanel() {

        addMouseListener(new CirclesListener());
        addMouseMotionListener(new CirclesListener());
        
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
    //-------------------------------------------------------------------
    // Draws the current circle, if any.
    //-------------------------------------------------------------------
    public void paintComponent (Graphics page) {
        super.paintComponent(page);
        if (circle != null) {
            circle.draw(page);
        }
    }

    //******************************************************************
    // Represents the listener for mouse events.
    //******************************************************************
    private class CirclesListener implements MouseListener,
            MouseMotionListener {
        //---------------------------------------------------------------
        // Creates a new circle at the current location whenever the
        // mouse button is pressed and repaints.
        //---------------------------------------------------------------
        public void mousePressed (MouseEvent event) {
            if (circle == null) {
                circle = new Circle(event.getPoint());
            }

            repaint();
        }

        //-----------------------------------------------------------------
        // Provide empty definitions for unused event methods.
        //-----------------------------------------------------------------
        public void mouseClicked (MouseEvent event) {}
        public void mouseReleased (MouseEvent event) {
            circle = null;
            repaint();
        }
        public void mouseEntered (MouseEvent event) {
            setBackground(Color.white);
        }
        public void mouseExited (MouseEvent event) {
            setBackground(Color.blue);
        }

        @Override
        public void mouseDragged(MouseEvent event) {
            // TODO Auto-generated method stub
            if (circle.isInside(event.getPoint())) {
                circle.move(event.getPoint());
            }
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
    }
}