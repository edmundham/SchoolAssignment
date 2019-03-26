package ca.bcit.comp2526.a2c;

import java.util.ArrayList;

/**
 * Omnivore.java
 * Omnivore that extends Animal and reproduces and acts like Omnivore.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Omnivore extends Animal {

    /**
     * generated serial version ID.
     */
    private static final long serialVersionUID = 1623876165767883229L;
    private static final int MAX_LIFE = 2;
    private static final int MIN_FOOD = 3;
    private static final int MIN_EMPTY = 3;
    private Cell location;
    private Cell newLocation;
    private Cell[] adjacentCells;
    private Cell[] adjacentPlantCells;
    private Cell[] adjacentHerbivoreCells;
    private Cell[] adjacentCarnivoreCells;
    private Cell[] adjacentNatureCells;
    private Cell[] edibleArray;
    
    /**
     * Constructs Omnivore objects.
     * @param location of the omnivore
     */
    public Omnivore(final Cell location) {
        super(location);
        this.location = location;
    }

    /**
     * sets edible lifeForms, can eat plant, herbivore, and carnivore.
     */
    public void setEdible() {
        ArrayList<Cell> tempEdible = new ArrayList<Cell>();
        // to initialize arrays of adjacent cells
        location.countPlant();
        location.countHerbivore();
        location.countCarnivore();
        // to initialize instance variables of Omnivore
        adjacentPlantCells = location.getAdjacentPlantCells();
        adjacentHerbivoreCells = location.getAdjacentHerbivoreCells();
        adjacentCarnivoreCells = location.getAdjacentCarnivoreCells();
        for (int i = 0; i < adjacentPlantCells.length; i++) {
            tempEdible.add(adjacentPlantCells[i]);
        }
        for (int i = 0; i < adjacentHerbivoreCells.length; i++) {
            tempEdible.add(adjacentHerbivoreCells[i]);
        }
        for (int i = 0; i < adjacentCarnivoreCells.length; i++) {
            tempEdible.add(adjacentCarnivoreCells[i]);
        }
        edibleArray = new Cell[tempEdible.size()];
        tempEdible.toArray(edibleArray);
    }
    
    /**
     * acts to eat, if there is no food, moves to the empty cell.
     */
    public void act() {
        int randomNum;
        if (!getBaby()) {
            incrementDeathCounter();
            this.setEdible();
            if (edibleArray.length > 0) {
                setDeathCounter(0);
                randomNum = RandomGenerator.nextNumber(
                        edibleArray.length);
                newLocation = edibleArray[randomNum];
                location.removeCreature();
                location = newLocation;
                location.setCreature(this, LifeForm.OMNIVORE);
            } else if (location.countNature() > 0) {
                adjacentNatureCells = location.getAdjacentNatureCells();
                randomNum = RandomGenerator.nextNumber(
                        adjacentNatureCells.length);
                newLocation = adjacentNatureCells[randomNum];
                location.removeCreature();
                location = newLocation;
                location.setCreature(this, LifeForm.OMNIVORE);
            }
        }
    }

    /**
     * dies when it starves more than 2 turns.
     */
    public void die() {
        if (getDeathCounter() == MAX_LIFE) {
            location.removeCreature();
        }
    }
    
    /**
     * reproduces if it has more than 3 neighboring foods,
     * 3 neighboring empty cells,
     * 1 neighboring omnivore cell, and the target cell is empty.
     */
    public void reproduce() {
        adjacentCells = location.getAdjacentCells();
        this.setEdible();
        for (int i = 0; i < adjacentCells.length; i++) {
            int randomNum = RandomGenerator.nextNumber(adjacentCells.length);
            if (adjacentCells[randomNum].isEmpty()
                    && edibleArray.length >= MIN_FOOD
                    && location.countNature() >= MIN_EMPTY
                    && location.countOmnivore() >= 1) {
                adjacentCells[randomNum].setCreature(
                        new Omnivore(adjacentCells[randomNum]),
                        LifeForm.OMNIVORE);
                break;
            }
        }
    }

}
