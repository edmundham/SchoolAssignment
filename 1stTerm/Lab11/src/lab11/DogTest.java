package lab11;

public class DogTest {

    public static void main(String[] args) {
        
//        Dog dog = new Dog("Spike");
//        System.out.println(dog.getName() + " says " + dog.speak());
        
        Labrador dog1 = new Labrador("Hyeju", "Yellow");
        Yorkshire dog2 = new Yorkshire("Sunguk");
        
        System.out.println(dog1.getName() + " says " + dog1.speak());
        System.out.println(dog2.getName() + " says " + dog2.speak());
        
        System.out.println(dog1.avgBreedWeight());
        System.out.println(dog2.avgBreedWeight());
        
    }
    
}
