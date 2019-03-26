package lab6;

public class Coin {

    private final int heads = 0;
    private final int tails = 1;
    
    private int face;
    
    /**
     * Sets up the coin by flipping it initially.
     */
    public Coin() {
        flip();
    }
    
    /**
     * Flips the coin by randomly choosing a face.
     */
    public void flip() {
        face = (int) (Math.random() * 2);
    }
    
    /**
     * returns true if the current face of the coin is heads
     */
    public boolean isHeads() {
        return (face == heads);
    }
    
    /**
     * returns the current face of the coin as a string.
     */
    public String toString() {
        String faceName;
        
        if (face == heads) {
            faceName = "Heads";
        }   else {
            faceName = "Tails";
        }
        return faceName;
    }
    
    
    
}
