package ca.bcit.comp2526.a2a;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * GameFrame.java
 * GameFrame that extends JFrame and contains all components
 * that are needed to be for the game.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class GameFrame extends JFrame {
    
    /**
     * Generated serial version UID.
     */
    private static final long serialVersionUID = 1623876165767883229L;
    private final World world;

    /**
     * GameFrame constructor that accepts World parameter.
     * @param world used for initializing world object in GameFrame class
     */
    public GameFrame(final World world) {
        this.world = world;
    }

    /**
     * initializes GameFrame.
     */
    public void init() {
        setTitle("Assignment 2a");
        setLayout(new GridLayout(world.getRowCount(), world.getColumnCount()));

        for (int col = 0; col < world.getRowCount(); col++) {
            for (int row = 0; row < world.getColumnCount(); row++) {
                add(world.getCellAt(col, row));
            }
        }

        addMouseListener(new TurnListener(this));
    }

    /**
     * calls takeTurn method in world class and repaints the JFrame.
     */
    public void takeTurn() {
        world.takeTurn();
        repaint();
    }
}
