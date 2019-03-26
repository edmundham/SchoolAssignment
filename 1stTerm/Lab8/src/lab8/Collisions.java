package lab8;

public class Collisions {

    public static void main(String[] args) {
        
        int maxSteps = 100000;
        int maxCoord = 2000000;
        int collide = 0;
        
        RandomWalk particle1 = new RandomWalk(maxSteps, maxCoord, -3, 0);
        RandomWalk particle2 = new RandomWalk(maxSteps, maxCoord, 3, 0);
        
        for (int i = 0; i < maxSteps; i++) {
            
            particle1.walk();
            particle2.walk();
            
            particle1.getCount();
            particle2.getCount();
            
            if (samePosition(particle1, particle2)) {
                collide++;
            }
                
            System.out.println("particle1: " + particle1);
            System.out.println("particle2: " + particle2);
            System.out.println("========================================"
                    + "=========================");
        }
        
        System.out.println("Collision: " + collide);
        System.out.println("Farthest distance: " + particle1.getMaxDistance());
        System.out.println("Farthest distance: " + particle2.getMaxDistance());
    }
    
    public static boolean samePosition(RandomWalk p1, RandomWalk p2) {
        
        if (p1.getX() == p2.getX() && p1.getY() == p2.getY()) {
            return true;
        }   else {
            return false;
        }
        
    }
    
}
