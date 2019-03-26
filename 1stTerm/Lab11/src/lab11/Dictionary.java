package lab11;

public class Dictionary extends Book {

    private int definitions = 52500;
    
    public double computeRation() {
        return (double) definitions / pages;
        //Be able to use pages in Book class since it is declared
        //as protected modifier.
    }
    
    public void setDefinitions(int numDefinitions) {
        definitions = numDefinitions;
    }
    
    public int getDefinitions() {
        return definitions;
    }
    
}
