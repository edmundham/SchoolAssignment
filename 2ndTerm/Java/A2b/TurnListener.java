package ca.bcit.comp2526.a2b;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * TurnListener.java
 * TurnLIstener class that extends MouseAdapter class and 
 * overrides mouseClicked method.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class TurnListener extends MouseAdapter {

    private final GameFrame gameFrame;
    
    /**
     * TurnListener constructor that accepts gameFrame objects.
     * @param gameFrame will be taken a turn
     */
    public TurnListener(final GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    /**
     * invokes takeTurn method in GameFrame class when mouse is clicked.
     * @param event 
     */
    public void mouseClicked(final MouseEvent event) {
        gameFrame.takeTurn();
    }
}
