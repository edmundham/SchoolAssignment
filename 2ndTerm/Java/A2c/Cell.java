package ca.bcit.comp2526.a2c;

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
    private static final long serialVersionUID = 1623876165767883229L;
    private static final Color LINE_COLOR = Color.black;
    private static final Color CELL_COLOR = Color.white;
    private static final Color PLANT_COLOR = Color.green;
    private static final Color HERBIVORE_COLOR = Color.yellow;
    private static final Color CARNIVORE_COLOR = Color.magenta;
    private static final Color OMNIVORE_COLOR = Color.blue;
    private final int row;
    private final int column;
    private final World world;
    private final Point location;
    private Creature creature;
    private LifeForm lifeForm;
    private Cell[] adjacentCells;
    private Cell[] adjacentPlantCells;
    private Cell[] adjacentNatureCells;
    private Cell[] adjacentHerbivoreCells;
    private Cell[] adjacentOmnivoreCells;
    private Cell[] adjacentCarnivoreCells;

    /**
     * Constructor that makes a cell inside the world.
     * @param world is the base of the cell
     * @param column number of the Cell
     * @param row number of the Cell
     */
    public Cell(final World world, final int column, final int row) {
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
        if (lifeForm == LifeForm.CARNIVORE) {
            this.setBackground(CARNIVORE_COLOR);
        }
        if (lifeForm == LifeForm.OMNIVORE) {
            this.setBackground(OMNIVORE_COLOR);
        }
    }
    
    /**
     * counts neighboring plant cells, and store those to the array.
     * @return the number of neighboring plant cells
     */
    public int countPlant() {
        ArrayList<Cell> tempPlantCells = new ArrayList<Cell>();
        adjacentCells = this.getAdjacentCells();
        
        for (int i = 0; i < adjacentCells.length; i++) {
            if (adjacentCells[i].getLifeForm() == LifeForm.PLANT) {
                tempPlantCells.add(adjacentCells[i]);
            }
        }
        adjacentPlantCells = new Cell[tempPlantCells.size()];
        tempPlantCells.toArray(adjacentPlantCells);
        return adjacentPlantCells.length;
    }
    
    /**
     * counts neighboring nature cells, and store those to the array.
     * @return the number of neighboring nature cells
     */
    public int countNature() {
        ArrayList<Cell> tempNatureCells = new ArrayList<Cell>();
        adjacentCells = this.getAdjacentCells();
        
        for (int i = 0; i < adjacentCells.length; i++) {
            if (adjacentCells[i].getLifeForm() == LifeForm.NATURE) {
                tempNatureCells.add(adjacentCells[i]);
            }
        }
        adjacentNatureCells = new Cell[tempNatureCells.size()];
        tempNatureCells.toArray(adjacentNatureCells);
        return adjacentNatureCells.length;
    }
    
    /**
     * counts neighboring herbivore cells, and store those to the array.
     * @return the number of neighboring herbivore cells
     */
    public int countHerbivore() {
        ArrayList<Cell> tempHerbivoreCells = new ArrayList<Cell>();
        adjacentCells = this.getAdjacentCells();
        
        for (int i = 0; i < adjacentCells.length; i++) {
            if (adjacentCells[i].getLifeForm() == LifeForm.HERBIVORE) {
                tempHerbivoreCells.add(adjacentCells[i]);
            }
        }
        adjacentHerbivoreCells = new Cell[tempHerbivoreCells.size()];
        tempHerbivoreCells.toArray(adjacentHerbivoreCells);
        return adjacentHerbivoreCells.length;
    }
    
    /**
     * counts neighboring carnivore cells, and store those to the array.
     * @return the number of neighboring carnivore cells
     */
    public int countCarnivore() {
        ArrayList<Cell> tempCarnivoreCells = new ArrayList<Cell>();
        adjacentCells = this.getAdjacentCells();
        
        for (int i = 0; i < adjacentCells.length; i++) {
            if (adjacentCells[i].getLifeForm() == LifeForm.CARNIVORE) {
                tempCarnivoreCells.add(adjacentCells[i]);
            }
        }
        adjacentCarnivoreCells = new Cell[tempCarnivoreCells.size()];
        tempCarnivoreCells.toArray(adjacentCarnivoreCells);
        return adjacentCarnivoreCells.length;
    }
    
    /**
     * counts neighboring omnivore cells, and store those to the array.
     * @return the number of neighboring omnivore cells
     */
    public int countOmnivore() {
        ArrayList<Cell> tempOmnivoreCells = new ArrayList<Cell>();
        adjacentCells = this.getAdjacentCells();
        
        for (int i = 0; i < adjacentCells.length; i++) {
            if (adjacentCells[i].getLifeForm() == LifeForm.OMNIVORE) {
                tempOmnivoreCells.add(adjacentCells[i]);
            }
        }
        adjacentOmnivoreCells = new Cell[tempOmnivoreCells.size()];
        tempOmnivoreCells.toArray(adjacentOmnivoreCells);
        return adjacentOmnivoreCells.length;
    }
    
    /**
     * checks if the cell is empty.
     * @return true if the cell is empty
     */
    public boolean isEmpty() {
        if (this.lifeForm == LifeForm.NATURE) {
            return true;
        }
        return false;
    }
    
    /**
     * gets the array of the adjacent plant cells.
     * @return the array of the adjacent plant cells
     */
    public Cell[] getAdjacentPlantCells() {
        return adjacentPlantCells;
    }
    
    /**
     * gets the array of the adjacent nature cells.
     * @return the array of the adjacent nature cells
     */
    public Cell[] getAdjacentNatureCells() {
        return adjacentNatureCells;
    }
    
    /**
     * gets the array of the adjacent herbivore cells.
     * @return the array of the adjacent herbivore cells.
     */
    public Cell[] getAdjacentHerbivoreCells() {
        return adjacentHerbivoreCells;
    }
    
    /**
     * gets the array of the adjacent carnivore cells.
     * @return the array of the adjacent carnivore cells.
     */
    public Cell[] getAdjacentCarnivoreCells() {
        return adjacentCarnivoreCells;
    }
    
    /**
     * gets the array of the adjacent omnivore cells.
     * @return the array of the adjacent omnivore cells.
     */
    public Cell[] getAdjacentOmnivoreCells() {
        return adjacentOmnivoreCells;
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
    public void setLifeForm(final LifeForm lifeForm) {
        this.lifeForm = lifeForm;
        if (lifeForm == LifeForm.PLANT) {
            creature = new Plant(this);
        }
        if (lifeForm == LifeForm.HERBIVORE) {
            creature = new Herbivore(this);
        }
        if (lifeForm == LifeForm.CARNIVORE) {
            creature = new Carnivore(this);
        }
        if (lifeForm == LifeForm.OMNIVORE) {
            creature = new Omnivore(this);
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
     * sets the creature object, and make it baby.
     * @param newCreature is the creature that is created
     * @param newLifeForm is the lifeForm that is created
     */
    public void setCreature(final Creature newCreature,
            final LifeForm newLifeForm) {
        this.lifeForm = newLifeForm;
        this.creature = newCreature;
        creature.setBaby(true);
    }
    
    /**
     * removes creature object.
     */
    public void removeCreature() {
        lifeForm = LifeForm.NATURE;
        creature = null;
    }
    
}
