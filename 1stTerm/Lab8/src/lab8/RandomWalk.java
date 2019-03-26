package lab8;

import java.util.Random;

public class RandomWalk {

    // x current coord
    private int startX;
    // y current coord
    private int startY;
    // maximum steps in the walk
    private int max;
    // number of steps taken
    private int curSteps;
    // boundary of the square
    private int edge;
    // counts how many times drunken fell off
    private int count;
    // maximum distance
    private int maxDistance;
    
    private Random random = new Random();
    
    public RandomWalk(int max, int edge) {
        this.max = max;
        this.edge = edge;
        startX = 0;
        startY = 0;
        curSteps = 0;
        maxDistance = 0;
    }
    
    public RandomWalk(int max, int edge, int startX, int startY) {
        this.max = max;
        this.edge = edge;
        this.startX = startX;
        this.startY = startY;
        curSteps = 0;
        maxDistance = 0;
    }
    
    private void takeStep() {
        
        int randomNum = random.nextInt(4);
        
        switch (randomNum) {
        
        case 0:
            startX++;
            curSteps++;
            break;
        case 1:
            startX--;
            curSteps++;
            break;
        case 2:
            startY++;
            curSteps++;
            break;
        case 3:
            startY--;
            curSteps++;
            break;
        }   
        
        if (maxDistance < max(startX, startY)) {
            maxDistance = max(startX, startY);            
        }
        
    }
    
    private int max(int num1, int num2) {
        if (Math.abs(num1) >= Math.abs(num2)) {
            return Math.abs(num1);
        }   else {
            return Math.abs(num2);
        }
    }
    
    public int getMaxDistance() {
        return maxDistance;
    }
    
    private boolean moreSteps() {
        if (curSteps <= max) {
            return true;
        }   else {
            return false;
        }
    }
    
    private boolean inBounds() {
        if (startX < edge && startY < edge && (startX > (-1) * edge)
                && (startY > (-1) * edge)) {
            return true;
        }   else {
            return false;
        }
    }
    
    public void walk() {
        if (moreSteps() && inBounds()) {
            takeStep();
        }   else {
            curSteps++;
            startX = 0;
            startY = 0;
            System.out.println("Alive!");
        }
    }
    
    public int getCount() {
        if (!inBounds()) {
            return count++;
        }   else {
            return count;
        }
    }
    
    public int getX() {
        return startX;
    }
    
    public int getY() {
        return startY;
    }
    
    
    
    public String toString() {
        return "Falls off: " + count + "; Steps: " + curSteps + "; Position: (" + startX + ", "
    + startY + ")";
    }
    
    
    
    
    
    
}
