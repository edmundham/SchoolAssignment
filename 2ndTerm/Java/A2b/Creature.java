package ca.bcit.comp2526.a2b;


/**
 * Creature.java
 * Creature class which is abstract that contains 
 * methods and instance variables.
 * 
 * @author Sunguk (Edmund) Ham
 * @version 1.0
 */
public abstract class Creature {
    
    private boolean baby;
    
    /**
     * Construct Creature object.
     * @param location of the Creature
     */
    public Creature(final Cell location) {
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
     * sets whether it is baby or not.
     * @param baby which is boolean type shows whether 
     * creature is newly born or not.
     */
    public void setBaby(final boolean baby) {
        this.baby = baby;
    }
    
    /**
     * reproduces creature. (all creatures reproduce)
     */
    public abstract void reproduce();

}

