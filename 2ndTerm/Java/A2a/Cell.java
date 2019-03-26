package ca.bcit.comp2526.a2a;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Cell.java
 * Cell class that extends JPanel can be either plant or herbivore.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Cell extends JPanel {
    
    /**
     * generated serial version ID.
     */
    private static final long serialVersionUID = 8764859018873039120L;
    private static final Color LINE_COLOR = Color.black;
    private static final Color CELL_COLOR = Color.white;
    private static final Color PLANT_COLOR = Color.green;
    private static final Color HERBIVORE_COLOR = Color.yellow;
    private final int row;
    private final int column;
    private final World world;
    private final Point location;
    private Creature creature;
    private LifeForm lifeForm;

    /**
     * Constructor that makes a cell inside the world.
     * @param world is the base of the cell
     * @param column number of the Cell
     * @param row number of the Cell
     */
    public Cell(World world, int column, int row) {
        this.row = row;
        this.column = column;
        this.world = world;
        location = new Point(row, column);
        lifeForm = LifeForm.NATURE;
        setBorder(BorderFactory.createLineBorder(LINE_COLOR));
    }
    
    /**
     * gets creature object.
     * @return creature
     */
    public Creature getCreature() {
        return creature;
    }
    
    /**
     * initializes Cell, based on the type of the lifeForm.
     */
    public void init() {
        if (lifeForm == LifeForm.PLANT) {
            this.setBackground(PLANT_COLOR);
        }
        if (lifeForm == LifeForm.HERBIVORE) {
            this.setBackground(HERBIVORE_COLOR);
        }
        if (lifeForm == LifeForm.NATURE) {
            this.setBackground(CELL_COLOR);
        }
    }
    
    /**
     * gets lifeForm enum type.
     * @return lifeForm enum type
     */
    public LifeForm getLifeForm() {
        return lifeForm;
    }
    
    /**
     * sets lifeForm enum type.
     * @param lifeForm enum type
     */
    public void setLifeForm(LifeForm lifeForm) {
        this.lifeForm = lifeForm;
        if (lifeForm == LifeForm.PLANT) {
            creature = new Plant(this);
        }
        if (lifeForm == LifeForm.HERBIVORE) {
            creature = new Herbivore(this);
        }
        if (lifeForm == LifeForm.NATURE) {
            creature = null;
        }
    }
    
    /**
     * gets Point Location.
     * @return location which is a Point object
     */
    public Point getLocation() {
        return location;
    }
    
    /**
     * gets array of adjacent Cell. length can be 3, 5, or 8.
     * @return returnCells which is the array of adjacent Cells
     */
    public Cell[] getAdjacentCells() {
        Cell[] returnCells;
        ArrayList<Cell> tempCells = new ArrayList<Cell>();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (row + j >= 0 
                        && row + j <= world.getRowCount() - 1
                        && column + i >= 0 
                        && column + i <= world.getColumnCount() - 1
                        && !(row + j == row
                        && column + i == column)) {
                    tempCells.add(world.getCellAt(column + i, row + j));
                }
            }
        }
        
        returnCells = new Cell[tempCells.size()];
        for (int i = 0; i < returnCells.length; i++) {
            returnCells[i] = tempCells.get(i);                
        }
        
        return returnCells;
    }
    
    /**
     * gets row number of the Cell.
     * @return row number of the cell
     */
    public int getRow() {
        return row;
    }
    
    /**
     * gets column number of the Cell.
     * @return column number of the cell
     */
    public int getColumn() {
        return column;
    }
    
    /**
     * gets the base world of the cell.
     * @return world of the cell
     */
    public World getWorld() {
        return world;
    }
    
    /**
     * sets the plant object, and make it baby.
     * @param plant object which acts like plants
     */
    public void setPlant(Plant plant) {
        lifeForm = LifeForm.PLANT;
        creature = plant;
        creature.setBaby(true);
    }
    
    /**
     * removes plant object.
     */
    public void removePlant() {
        lifeForm = LifeForm.NATURE;
        creature = null;
    }
    
    /**
     * sets the herbivore object, and make it baby.
     * @param herbivore object which acts like herbivore
     */
    public void setHerbivore(Herbivore herbivore) {
        lifeForm = LifeForm.HERBIVORE;
        creature = herbivore;
        creature.setBaby(true);
    }
    
    /**
     * removes herbivore object.
     */
    public void removeHerbivore() {
        lifeForm = LifeForm.NATURE;
        creature = null;            
    }
}
