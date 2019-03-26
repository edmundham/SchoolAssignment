package lab8;

public class BiasedCoin {

    private final int heads = 0;
    private final int tails = 1;
    private final double biased = 0.6;
    private double random;
    
    private int face;
    
    /**
     * Sets up the coin by flipping it initially.
     */
    public BiasedCoin() {
        flip();
    }
    
    /**
     * Flips the coin by randomly choosing a face.
     */
    public void flip() {
        random = Math.random();
        face = flipResult();
    }
    
    private int flipResult() {
        if (random >= biased) {
            return tails;
        }   else {
            return heads;
        }
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

