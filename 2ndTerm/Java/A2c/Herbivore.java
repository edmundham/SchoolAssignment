package ca.bcit.comp2526.a2c;

import java.util.ArrayList;

/**
 * Herbivore.java
 * Herbivore that extends Animal and reproduces and acts like Herbivore.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Herbivore extends Animal {
    
    /**
     * generated serial version ID.
     */
    private static final long serialVersionUID = 1623876165767883229L;
    private static final int MAX_LIFE = 10;
    private Cell location;
    private Cell newLocation;
    private Cell[] adjacentCells;
    private Cell[] adjacentPlantCells;
    private Cell[] adjacentNatureCells;
    private Cell[] edibleArray;
    
    /**
     * Construct Herbivore object.
     * @param location of the herbivore
     */
    public Herbivore(final Cell location) {
        super(location);
        this.location = location;
    }
    
    /**
     * reproduces if it has more than 2 neighbor herbivore,
     * 1 neighbor empty cell,
     * 2 neighbor plant cells, and the target cell is empty.
     */
    public void reproduce() {
        adjacentCells = location.getAdjacentCells();
        for (int i = 0; i < adjacentCells.length; i++) {
            int randomNum = RandomGenerator.nextNumber(adjacentCells.length);
            if (adjacentCells[randomNum].isEmpty()
                    && location.countHerbivore() >= 2
                    && location.countNature() >= 1
                    && location.countPlant() >= 2) {
                adjacentCells[randomNum].setCreature(
                        new Herbivore(adjacentCells[randomNum]),
                        LifeForm.HERBIVORE);
                break;
            }
        }
    }
    
    /**
     * sets edible life forms and stores in edibleArray.
     */
    public void setEdible() {
        ArrayList<Cell> tempEdible = new ArrayList<Cell>();
        location.countPlant();
        adjacentPlantCells = location.getAdjacentPlantCells();
        for (int i = 0; i < adjacentPlantCells.length; i++) {
            tempEdible.add(adjacentPlantCells[i]);
        }
        edibleArray = new Cell[tempEdible.size()];
        tempEdible.toArray(edibleArray);
    }
    
    /**
     * eats plant, if there is no neighboring plant, then move to
     * the empty cell.
     */
    public void act() {
        int randomNum;
        incrementDeathCounter();
        this.setEdible();
        if (location.countPlant() > 0) {
            setDeathCounter(0);
            randomNum = RandomGenerator.nextNumber(
                    adjacentPlantCells.length);
            newLocation = edibleArray[randomNum];
            location.removeCreature();
            location = newLocation;
            location.setCreature(this, LifeForm.HERBIVORE);
        } else if (location.countNature() > 0) {
            adjacentNatureCells = location.getAdjacentNatureCells();
            randomNum = RandomGenerator.nextNumber(
                    adjacentNatureCells.length);
            newLocation = adjacentNatureCells[randomNum];
            location.removeCreature();
            location = newLocation;
            location.setCreature(this, LifeForm.HERBIVORE);
        }
    }
    
    /**
     * make herbivore dead when it starves more than 10 turns.
     */
    public void die() {
        if (getDeathCounter() == MAX_LIFE) {
            location.removeCreature();
        }
    }

}
