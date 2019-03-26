package lab11;

public class FoodItem {

    final private int CALORIES_PER_GRAM = 9;
    private int fatGrams;
    protected int servings;
    
    public FoodItem(int numFatGrams, int numServings) {
        fatGrams = numFatGrams;
        servings = numServings;
    }
    
    private int calories() {
        return fatGrams * CALORIES_PER_GRAM;
    }
    
    public int caloriesPerServing() {
        return (calories() / servings);
    }
    
}
