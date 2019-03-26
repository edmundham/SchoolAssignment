package ca.bcit.comp2526.a2a;

/**
 * Creature.java
 * Creature class which is abstract that contains 
 * methods and instance variables.
 * 
 * @author Sunguk (Edmund) Ham
 * @version 1.0
 */
public abstract class Creature extends Cell {
    
    /**
     * generated serial ID by Eclipse.
     */
    private static final long serialVersionUID = -5673370150154959071L;
    private boolean baby;
    private int deathCounter;
    
    /**
     * Construct Creature object.
     * @param location of the Creature
     */
    public Creature(Cell location) {
        super(location.getWorld(), location.getColumn(), location.getRow());
        baby = true;
    }
    
    /**
     * gets baby variable.
     * @return boolean type baby
     */
    public boolean getBaby() {
        return baby;
    }
    
    /**
     * will be overriden to show behaviours of all creatures.
     */
    public abstract void act();

    /**
     * sets whether it is baby or not.
     * @param baby which is boolean type shows whether 
     * creature is newly born or not.
     */
    public void setBaby(boolean baby) {
        this.baby = baby;
    }
    
    /**
     * makes old creatures dead.
     */
    public abstract void die();
    
    /**
     * sets deathCounter of the creature.
     * @param deathCounter of the creature
     */
    public void setDeathCounter(int deathCounter) {
        this.deathCounter = deathCounter;
    }
    
    /**
     * increments deathCounter of the creature.
     */
    public void incrementDeathCounter() {
        deathCounter++;
    }
    
    /**
     * gets deathCounter of the creature.
     * @return deathCounter of the creature.
     */
    public int getDeathCounter() {
        return deathCounter;
    }
}
