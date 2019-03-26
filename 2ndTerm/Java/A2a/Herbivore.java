package ca.bcit.comp2526.a2a;

import java.util.ArrayList;

/**
 * Herbivore.java
 * Herbivore that extends Creature and acts like Herbivore.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Herbivore extends Creature {
    /**
     * generated serial version ID.
     */
    private static final long serialVersionUID = -5368556016946522358L;
    private static final int MAX_LIFE = 10;
    private Cell location;
    private Cell newLocation;
    private Cell[] adjacentCells;
    private Cell[] adjacentPlantCells;
    private Cell[] adjacentNatureCells;
    
    /**
     * Construct Herbivore object.
     * @param location of the herbivore
     */
    public Herbivore(Cell location) {
        super(location);
        this.location = location;
    }
    
    /**
     * acts like herbivore. ie. eats plants or moves.
     */
    public void act() {
        int randomNum;
        if (!getBaby()) {
            if (this.detectPlant()) {
                randomNum = RandomGenerator.nextNumber(
                        adjacentPlantCells.length);
                newLocation = adjacentPlantCells[randomNum];
                location.removeHerbivore();
                location = newLocation;
                location.setHerbivore(this);
                setDeathCounter(0);
            } else {
                randomNum = RandomGenerator.nextNumber(
                        adjacentNatureCells.length);
                newLocation = adjacentNatureCells[randomNum];
                location.removeHerbivore();
                location = newLocation;
                location.setHerbivore(this);
                incrementDeathCounter();
            }
        }
    }
    
    /**
     * make herbivore dead when it starves more than 10 turns.
     */
    public void die() {
        if (getDeathCounter() == MAX_LIFE) {
            location.removeHerbivore();
        }
    }
    
    private boolean detectPlant() {
        ArrayList<Cell> tempPlantCells = new ArrayList<Cell>();
        ArrayList<Cell> tempNatureCells = new ArrayList<Cell>();
        adjacentCells = location.getAdjacentCells();

        for (int i = 0; i < adjacentCells.length; i++) {
            if (adjacentCells[i].getLifeForm() == LifeForm.PLANT) {
                tempPlantCells.add(adjacentCells[i]);
            }
        }
        
        if (tempPlantCells.size() == 0) {
            for (int i = 0; i < adjacentCells.length; i++) {
                if (adjacentCells[i].getLifeForm() == LifeForm.NATURE) {
                    tempNatureCells.add(adjacentCells[i]);
                }
            }
        }

        adjacentPlantCells = new Cell[tempPlantCells.size()];
        adjacentNatureCells = new Cell[tempNatureCells.size()];
        for (int i = 0; i < adjacentPlantCells.length; i++) {
            adjacentPlantCells[i] = tempPlantCells.get(i);
        }
        for (int i = 0; i < adjacentNatureCells.length; i++) {
            adjacentNatureCells[i] = tempNatureCells.get(i);
        }
        
        return (adjacentPlantCells.length >= 1);
    }

}
