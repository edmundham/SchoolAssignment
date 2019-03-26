package q3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.text.DecimalFormat;

/**
 * <p>This program has nice-looking timer bar with 00:00 timer.
 * It also has start, stop, and reset button which can interact
 * with users. It only counts seconds and hundredth of second.
 * Even though instruction says tenth of seconds, hundredth of second
 * was chosen because it has same logic and it performs better looking.</p>
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 * 
 */
public class StopWatchPanel extends JPanel {
    
    /**
     * <p>Set the format of seconds and hundredth of seconds.</p>
     */
    private DecimalFormat fmt = new DecimalFormat("00");
    
    /**
     * <p>The number that is shown in the screen. It will be
     * formatted later using DecimalFormat. It is second.</p>
     */
    private int second;
    
    /**
     * <p>The number that is shown in the screen. It is hundredth of second.</p>
     */
    private int hundredth;
    
    /**
     * <p>This int used for performing timer bar. Width of the bar
     * which interacts with the timer.</p>
     */
    private int moveW;
    
    /**
     * <p>This int used for performing timer bar. Height of the bar.</p>
     */
    private final int pivotH = 100;
    
    /**
     * <p>When the button is pressed, it starts the timer.</p>
     */
    private JButton start = new JButton("Start");
    
    /**
     * <p>When the button is pressed, it resets the timer.</p>
     */
    private JButton reset = new JButton("Reset");
    
    /**
     * <p>When the button is pressed, it stops the timer.</p>
     */
    private JButton stop = new JButton("Stop");
    
    /**
     * <p>Label shows seconds and hundredth of second with nice-looking
     * format.</p>
     */
    private JLabel time = new JLabel(fmt.format(second) 
            + ":" + fmt.format(hundredth));
    
    /**
     * <p>Delay of timer object.</p>
     */
    private final int delay = 10;
    
    /**
     * <p>Timer class that interacts every 10 milliseconds.</p>
     */
    private Timer secondTimer = new Timer(delay, new SecondStopWatchListener());

    /**
     * <p>Constant used for constructing the panel width.</p>
     */
    private final int panelW = 400;
    
    /**
     * <p>Constant used for constructing the panel height.</p>
     */
    private final int panelH = 300;
    
    /**
     * <p>Constant used for making font bigger.</p>
     */
    private final int fontSize = 36;
    
    /**
     * <p>Constant used for organizing the panel.</p>
     */
    private final int organizingBox1 = 190;
    
    /**
     * <p>Constant used for organizing the panel.</p>
     */
    private final int organizingBox2 = 5;
    
    /**
     * <p>Constant used for organizing the panel.</p>
     */
    private final int organizingBox3 = 50;
    
    /**
     * <p>Constant used for organizing the panel.</p>
     */
    private final int organizingBox4 = 100;
    
    /**
     * <p>Constant used for adding 3 to moveW every 
     * hundredth of second.</p>
     */
    private final int movingW = 3;
    
    /**
     * <p>Constant limits maximum number of 
     * hundredth of second to 99.</p>
     */
    private final int maxHundreths = 99;
    
    /**
     * <p>Constructor organizes all components inside.</p>
     */
    public StopWatchPanel() {
        
        setBackground(Color.black);
        //(400, 300)
        setPreferredSize(new Dimension(panelW, panelH));
        
        time.setFont(new Font("Helveltica", Font.PLAIN, fontSize));
        time.setForeground(Color.white);
        
        start.addActionListener(new ButtonListener());
        stop.addActionListener(new ButtonListener());
        reset.addActionListener(new ButtonListener());
        
        //Styling buttons
        start.setBackground(Color.blue);
        start.setForeground(Color.white);
        stop.setBackground(Color.red);
        stop.setForeground(Color.white);
        reset.setBackground(Color.gray);
        reset.setForeground(Color.white);

        //Making the empty box, just for organizing
        //Dimension(400, 190)
        add(Box.createRigidArea(new Dimension(panelW, organizingBox1)));
        add(time);
        //Making the empty box, just for organizing
        //Dimension(400, 5)
        add(Box.createRigidArea(new Dimension(panelW, organizingBox2)));
        add(start);
        add(reset);
        add(stop);
    }
    
    /**
     * <p>This method creates three different traffic lights with gray
     * color.</p>
     * 
     * @param g is a paint component.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.white);
        //(50, 50, 300, 100)
        g.fillRect(organizingBox3, organizingBox3, panelH, organizingBox4);
        
        g.setColor(Color.green);
        //(50, 50, moveW, 100)
        g.fillRect(organizingBox3, organizingBox3, moveW, pivotH);
    }
    
    /**
     * <p>The class will make this program interactive with timer object.</p>
     * 
     * @author Sunguk (Edmund) Ham, Set E, A00979841
     */
    private class SecondStopWatchListener implements ActionListener {
        
        /**
         * <p>The method process the action of timer object.</p>
         * 
         * @param event unused
         */
        public void actionPerformed(ActionEvent event) {
            hundredth++;
            moveW += movingW;
            
            if (hundredth > maxHundreths && moveW > panelH) {
                hundredth = 0;
                second++;
                moveW = 0;
            }
            time.setText(fmt.format(second) + ":" + fmt.format(hundredth));
            repaint();
        }
    }
    
    /**
     * <p>The class will make this program interact with users using
     * JButton, in this program particularly.</p>
     */
    private class ButtonListener implements ActionListener {
        
        /**
         * <p>The method process the action of users.</p>
         * 
         * @param event used for taking the source by user pressing the buttons.
         */
        public void actionPerformed(ActionEvent event) {

            //It could have been solved by switch statement,
            //but if statement can also do the tasks effectively,
            //since there are only 3 buttons.
            if (event.getSource() == start) {
                secondTimer.start();
            }
            if (event.getSource() == reset) {
                secondTimer.stop();
                second = 0;
                hundredth = 0;
                moveW = 0;
                time.setText(fmt.format(second) + ":" + fmt.format(hundredth));
                repaint();
            }
            if (event.getSource() == stop) {
                secondTimer.stop();
            }
            
        }
    }
    
    
}
