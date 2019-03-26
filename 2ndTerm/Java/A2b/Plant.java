package ca.bcit.comp2526.a2b;

/**
 * Plant.java
 * Plant that extends creature and reproduces like plants.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Plant extends Creature {

    private static final int MIN_EMPTY_ADJACENT_CELL = 3;
    private Cell location;
    private Cell[] adjacentCells;
    
    /**
     * Construct Plant object.
     * @param location of the plant
     */
    public Plant(final Cell location) {
        super(location);
        this.location = location;
    }
    
    /**
     * reproduces plants if it has more than 2 neighboring plants,
     * 3 neighboring empty cells, and the target cell is empty.
     */
    public void reproduce() {
        adjacentCells = location.getAdjacentCells();
        for (int i = 0; i < adjacentCells.length; i++) {
            int randomNum = RandomGenerator.nextNumber(adjacentCells.length);
            if (adjacentCells[randomNum].isEmpty()
                    && location.countPlant() >= 2
                    && location.countNature()
                    >= MIN_EMPTY_ADJACENT_CELL) {
                adjacentCells[randomNum].setCreature(
                        new Plant(adjacentCells[randomNum]), LifeForm.PLANT);
                break;
            }
        }
    }
    
}
