package ca.bcit.comp2526.a2c;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * ButtonPanel.java
 * 
 * JPanel that contains all buttons of GameFrame. 
 * However, the class does not include
 * save and load button because those are added to ButtonPanel 
 * but instantiated in the GameFrame.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 *
 */
public class ButtonPanel extends JPanel {

    /**
     * generated serial version ID.
     */
    private static final long serialVersionUID = 1623876165767883229L;
    private static final int SLIDER_MAX_VALUE = 10;
    private static final int SLIDER_INITIAL_VALUE = 5;
    private static final int GRID_ROW = 3;
    private static final int GRID_COLUMN = 2;
    private static final int SPEED_INITIAL = 500;
    private static final int SLIDER_CALCULATOR_MINUS = 11;
    private static final int SLIDER_CALCULATOR_MULTIPLY = 100;
    private JButton startButton;
    private JButton resetButton;
    private JButton stopButton;
    private JSlider controlSlide;
    private GameFrame gameFrame;
    private Thread thread = new Thread(new DaemonThread());
    private int speed;
    private int counter;
    private boolean timeToRun = true;
    
    /**
     * construct ButtonPanel object that contains buttons.
     * 
     * @param gameFrame contains ButtonPanel
     * @param world contains all cells
     */
    public ButtonPanel(GameFrame gameFrame, World world) {
        startButton = new JButton("Start! 0.1 second to 1 second");
        resetButton = new JButton("Reset!");
        stopButton = new JButton("Stop!");
        controlSlide = new JSlider(1, SLIDER_MAX_VALUE, SLIDER_INITIAL_VALUE);
        controlSlide.setMinorTickSpacing(1);
        controlSlide.setPaintTicks(true);
        controlSlide.setPaintLabels(true);
        this.gameFrame = gameFrame;
        
        setLayout(new GridLayout(GRID_ROW, GRID_COLUMN));
        // initial speed
        speed = SPEED_INITIAL;
        
        startButton.addActionListener(new StartButtonListener());
        resetButton.addActionListener(new ResetButtonListener());
        stopButton.addActionListener(new StopButtonListener());
        controlSlide.addChangeListener(new SliderListener());
        
        add(startButton);
        add(resetButton);
        add(stopButton);
        add(controlSlide);
    }
    
    /**
     * sets timeToRun variable that is used for controlling Thread.
     * 
     * @param timeToRun true when it is time to run takeTurn method.
     */
    public void setTimeToRun(boolean timeToRun) {
        this.timeToRun = timeToRun;
    }
    
    private class StartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (counter == 0) {
                thread.setDaemon(true);
                thread.start();                
            }
            timeToRun = true;
        }
    }
    
    private class DaemonThread implements Runnable {
        public void run() {
            while (true) {
                try {
                    if (timeToRun) {
                        gameFrame.takeTurn();
                        counter++;
                    }
                    Thread.sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }                    
            }
        }
    }
    
    private class ResetButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            timeToRun = false;
            gameFrame.addGamePanel();
        }
    }
    
    private class StopButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            timeToRun = false;
        }
    }
    
    private class SliderListener implements ChangeListener {

        public void stateChanged(ChangeEvent e) {
            controlSlide = (JSlider) e.getSource();
            // 0.1 seconds to 1 seconds depends on the slide
            speed = (SLIDER_CALCULATOR_MINUS - controlSlide.getValue())
                    * SLIDER_CALCULATOR_MULTIPLY;

        }
    }
    
}
