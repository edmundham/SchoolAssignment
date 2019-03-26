package lab6;

public class Runs {

    public static void main(String[] args) {
        final int flips = 9999999;
        
        int currentRun = 0;
        int maxRun = 0;
        
        Coin loonies = new Coin();
        
        for (int count = 0; count < flips; count++) {
            
            loonies.flip();
            System.out.println(count);
            
            if (loonies.isHeads()) {
                currentRun++;
            }
            if (currentRun > maxRun){
                maxRun = currentRun;
            }
            if (!loonies.isHeads()) {
                currentRun = 0;
            }   
        }
        
        System.out.println("Maximum run for heads is " + maxRun + " times.");
        }
}
