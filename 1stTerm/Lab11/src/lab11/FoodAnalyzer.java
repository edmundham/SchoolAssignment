package lab11;

public class FoodAnalyzer {

    public static void main(String[] args) {
        
        Pizza special = new Pizza(275);
        
        System.out.println("Calories per serving: "
                + special.caloriesPerServing());
        
    }
    
}
