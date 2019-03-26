package ca.bcit.comp2526.a2a;

/**
 * Plant.java
 * Plant that extends creature and acts like plants.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Plant extends Creature {

    /**
     * generated serial version ID.
     */
    private static final long serialVersionUID = 830996314285288714L;
    private static final int MIN_EMPTY_ADJACENT_CELL = 3;
    private final Cell location;
    private Cell[] adjacentCells;
    
    /**
     * Construct Plant object.
     * @param location of the plant
     */
    public Plant(Cell location) {
        super(location);
        this.location = location;
    }
    
    /**
     * Empty method for the future use.
     * @param deathCounter of the plant
     */
    public void setDeathCounter(int deathCounter) {
        
    }
    
    /**
     * Empty method for the future use.
     * @return deathCoutner
     */
    public int getDeathCounter() {
        return 0;
    }
    
    /**
     * Empty method for the future use.
     */
    public void die() {
        
    }
    
    /**
     * acts like plants i.e. seeds to the empty cells.
     */
    public void act() {
        adjacentCells = location.getAdjacentCells();
        int randomNum = RandomGenerator.nextNumber(adjacentCells.length);
        for (int i = 0; i < adjacentCells.length; i++) {
            if (this.isEmpty(adjacentCells[randomNum])
                    && this.countNearPlant() >= 2
                    && this.countNearNature()
                    >= MIN_EMPTY_ADJACENT_CELL) {
                adjacentCells[randomNum].setPlant(this);
                break;
            }            
        }
    }
    
    private boolean isEmpty(Cell target) {
            if (target.getLifeForm() == LifeForm.NATURE) {
                return true;
            }
        return false;
    }
    
    private int countNearPlant() {
        int counter = 0;
        
        Cell[] adjacentTempCells = this.getAdjacentCells();
        for (int i = 0; i < adjacentTempCells.length; i++) {
            if (adjacentTempCells[i].getLifeForm() == LifeForm.PLANT) {
                counter++;
            }
        }
        
        return counter;
    }
    
    private int countNearNature() {
        int counter = 0;
        
        Cell[] adjacentTempCells = this.getAdjacentCells();
        for (int i = 0; i < adjacentTempCells.length; i++) {
            if (adjacentTempCells[i].getLifeForm() == LifeForm.NATURE) {
                counter++;
            }
        }
        
        return counter;
    }
    
}
