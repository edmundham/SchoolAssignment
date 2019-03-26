package ca.bcit.comp2526.a2c;

import java.util.ArrayList;

/**
 * Carnivore.java
 * Carnivore that extends Animal and reproduces and acts like Carnivore.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Carnivore extends Animal {

    /**
     * generated serial version ID.
     */
    private static final long serialVersionUID = 1623876165767883229L;
    private static final int MAX_LIFE = 7;
    private Cell location;
    private Cell newLocation;
    private Cell[] adjacentCells;
    private Cell[] adjacentHerbivoreCells;
    private Cell[] adjacentOmnivoreCells;
    private Cell[] adjacentNatureCells;
    private Cell[] edibleArray;
    
    /**
     * Constructs carnivore object.
     * @param location of the carnivore
     */
    public Carnivore(final Cell location) {
        super(location);
        this.location = location;
    }

    /**
     * sets edible lifeForms, can eat herbivore and omnivore.
     */
    public void setEdible() {
        ArrayList<Cell> tempEdible = new ArrayList<Cell>();
        // to initialize arrays of adjacent cells
        location.countHerbivore();
        location.countOmnivore();
        // to initialize instance variables of Carnivore
        adjacentHerbivoreCells = location.getAdjacentHerbivoreCells();
        adjacentOmnivoreCells = location.getAdjacentOmnivoreCells();
        
        for (int i = 0; i < adjacentHerbivoreCells.length; i++) {
            tempEdible.add(adjacentHerbivoreCells[i]);
        }
        for (int i = 0; i < adjacentOmnivoreCells.length; i++) {
            tempEdible.add(adjacentOmnivoreCells[i]);
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
                location.setCreature(this, LifeForm.CARNIVORE);
            } else if (location.countNature() > 0) {
                adjacentNatureCells = location.getAdjacentNatureCells();
                randomNum = RandomGenerator.nextNumber(
                        adjacentNatureCells.length);
                newLocation = adjacentNatureCells[randomNum];
                location.removeCreature();
                location = newLocation;
                location.setCreature(this, LifeForm.CARNIVORE);
            }
        }
    }

    /**
     * dies when it starves more than 7 turns.
     */
    public void die() {
        // TODO Auto-generated method stub
        if (getDeathCounter() == MAX_LIFE) {
            location.removeCreature();
        }
    }
    
    /**
     * reproduces if it has more than 2 neighboring foods,
     * 2 neighboring empty cells,
     * 1 neighboring carnivore cell, and the target cell is empty.
     */
    public void reproduce() {
        adjacentCells = location.getAdjacentCells();
        this.setEdible();
        for (int i = 0; i < adjacentCells.length; i++) {
            int randomNum = RandomGenerator.nextNumber(adjacentCells.length);
            if (adjacentCells[randomNum].isEmpty()
                    && edibleArray.length >= 2
                    && location.countNature() >= 2
                    && location.countCarnivore() >= 1) {
                adjacentCells[randomNum].setCreature(
                        new Carnivore(adjacentCells[randomNum]),
                        LifeForm.CARNIVORE);
                break;
            }
        }
    }

}
