package ca.bcit.comp2526.a2b;

/**
 * Animal.java
 * Abstract animal class which extends Creature and is extended by
 * different kinds of animals. It contains variables and methods related
 * to the animals.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public abstract class Animal extends Creature {
    
    private int deathCounter;

    /**
     * Construct Animal object.
     * 
     * @param location of the animal
     */
    public Animal(final Cell location) {
        super(location);
    }
    
    /**
     * makes old animals dead.
     */
    public abstract void die();
    
    /**
     * acts like animals. All animal act or move.
     */
    public abstract void act();
    
    /**
     * sets edible creatures All animal eat something.
     */
    public abstract void setEdible();
    
    /**
     * sets deathCounter of the animal.
     * @param deathCounter of the animal
     */
    public void setDeathCounter(final int deathCounter) {
        this.deathCounter = deathCounter;
    }

    /**
     * increments deathCounter of the animal.
     */
    public void incrementDeathCounter() {
        deathCounter++;
    }
    
    /**
     * gets deathCounter of the animal.
     * @return deathCounter of the animal.
     */
    public int getDeathCounter() {
        return deathCounter;
    }
}

