package q4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * <p>This is the class which is related to TrafficLight.java which is a frame.
 * It contains the button that can change the traffic lights' color
 * and traffic light panel.</p>
 *
 * @author Sunguk (Edmund) Ham, A00979841, Set E
 * @version 1.0
 */
public class TrafficLightPanel  extends JPanel {
    
    /**
     * <p>Creating button which can change traffic light.</p>
     */
    private JButton button;
    
    /**
     * <p>Setting three lights to gray color at very first.</p>
     */
    private Color color1 = Color.gray;
    
    /**
     * <p>Setting three lights to gray color at very first.</p>
     */
    private Color color2 = Color.gray;
    
    /**
     * <p>Setting three lights to gray color at very first.</p>
     */
    private Color color3 = Color.gray;
    
    /**
     * <p>The number determines the order of each light.</p>
     */
    private int count;
    
    /**
     * <p>The natural number increments after
     *  the whole if statement.</p>
     */
    private int natural = 1;
    
    /**
     * <p>The number was used to locate traffic lights.</p>
     */
    private final int basic = 30;

    /**
     * <p>The number was used to locate traffic lights, and to calculate
     * the natural number.</p>
     */
    private final int num3 = 3;
    
    /**
     * <p>The number was used to locate traffic lights.</p>
     */
    private final int num5 = 5;
    
    /**
     * <p>The number was used to locate traffic lights.</p>
     */
    private final int num9 = 9;
    
    /**
     * <p>The constructor has the button which can change the
     * traffic lights and the panel which contain traffic lights.</p>
     */
    public TrafficLightPanel() {
        
        //Set the text shown on the button.
        button = new JButton("Change");
        
        //Set the button to serve certain actions.
        ButtonListener listener = new ButtonListener();
        button.addActionListener(listener);
        
        //Width of the main panel
        final int mainPanelW = 200;
        //Height of the main panel
        final int mainPanelH = 480;
        
        //Set the size and the color of main panel.
        setPreferredSize(new Dimension(mainPanelW, mainPanelH));
        setBackground(Color.yellow);
        
        //Set the DrawingPanel object, containing traffic
        //lights, called panel.
        DrawingPanel panel = new DrawingPanel();
        
        /**
         * <p>Adding both button which can change
         * the traffic lights and panel which
         * contains traffic lights.</p>
         */
        add(button);
        add(panel);
    }

    
    /**
     * <p>The class contains three traffic lights with gray
     * color.</p>
     * 
     * @author Sunguk (Edmund) Ham, A00979841, Set E
     * 
     */
    class DrawingPanel extends JPanel {
        
        /**
         * <p>Width of the black background of three traffic lights.</p>
         */
        private final int trafficLightW = 150;
        
        /**
         * <p>Height of the black background of three traffic lights.</p>
         */
        private final int trafficLightH = 400;
        
        /**
         * <p>The constructor has three traffic lights with gray
         * color and black background.</p>
         */
        DrawingPanel() {
            //Set a background box of traffic lights.
            setPreferredSize(new Dimension(trafficLightW, trafficLightH));
            setBackground(Color.black);
        }
        
        /**
         * <p>This method creates three different traffic lights with gray
         * color.</p>
         * 
         * @param g is a paint component.
         */
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            //First traffic light
            g.setColor(color1);
            g.fillOval(basic, basic, num3 * basic, num3 * basic);
            
            //Second traffic light
            g.setColor(color2);
            g.fillOval(basic, num5 * basic, num3 * basic, num3 * basic);
            
            //Second traffic light
            g.setColor(color3);
            g.fillOval(basic, num9 * basic, num3 * basic, num3 * basic);   
            repaint();
        }
    }
    
    /**
     * <p>The class will make this program interact with users using
     * JButton, in this program particularly.</p>
     * 
     * @author Sunguk (Edmund) Ham, A00979841, Set E
     *
     */
    private class ButtonListener implements ActionListener {
        
        /**
         * <p>The method process the action of users.</p>
         * 
         * @param event unused.
         */
        public void actionPerformed(ActionEvent event) {
            
            // increment int count whenever user clicked the button
            count++;
            
            // if count is 1, first traffic light turns green,
            // and third traffic light turns gray
            // if count is 2, first traffic light turns gray,
            // and second traffic lights turns orange
            // if count is 0, second traffic lights turns gray,
            // third traffic lights turns red, and int natural is incremented
            // so that it can be adjusted to incrementing count automatically 
            if (count == num3 * natural - 2) {
                color1 = Color.green;
                color3 = Color.gray;
            }   else 
                    if (count == num3 * natural - 1) {
                        color1 = Color.gray;
                        color2 = Color.orange;
            }   else
                    if (count == num3 * natural) {
                        color2 = Color.gray;
                        color3 = Color.red;
                        natural++;   
            }            
        }
    }
};
