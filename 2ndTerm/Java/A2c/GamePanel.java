package ca.bcit.comp2526.a2c;

import java.awt.GridLayout;
import java.util.Iterator;
import javax.swing.JPanel;

/**
 * GamePanel.java
 * 
 * GamePanel that contains all visual cells. 
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 *
 */
public class GamePanel extends JPanel {

    /**
     * generated serial version ID.
     */
    private static final long serialVersionUID = 1623876165767883229L;
    private World world;
    private DoubleLinkedList<Cell> doublyLinkedList;
    
    /**
     * constructs GamePanel object with 
     * setting layout and instantiating doublyLinkedList.
     * 
     * @param world contains all cells
     */
    public GamePanel(World world) {
        this.world = world;
        doublyLinkedList = world.getDoublyLinkedList();
        setLayout(new GridLayout(this.world.getRowCount(), 
                this.world.getColumnCount()));
    }
    
    /**
     * initializes gamePanel object with cells.
     * contains 2 algorithms using for each loop and iterator.
     * To avoid checkstyle error, it is using iterator.
     */
    public void init() {
        
        // Implementing For-Each Loop
//        for (Cell element : doublyLinkedList) {
//            add(element);
//        }
        
        // Implementing Iterator
        Iterator<Cell> iterator = doublyLinkedList.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
    }
}
