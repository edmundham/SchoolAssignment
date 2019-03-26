package lab8;

public class DrunkenWalk {

    public static void main(String[] args) {
        
        int maxSteps = 500;
        int maxCoord = 10;
        
        RandomWalk walker = new RandomWalk(maxSteps, maxCoord, 0, 0);
        
        for (int i = 0; i < maxSteps; i ++) {
            walker.walk();
            walker.getCount();
            System.out.println(walker);
        }
        
        System.out.println("Farthest distance: " + walker.getMaxDistance());
    }
}
