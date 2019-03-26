package lab11;

public class Dictionary2 extends Book2 {

    private int definitions;
    
    public Dictionary2(int numPages, int numDefinitions) {
        
        super(numPages);
        
        definitions = numDefinitions;
    }
    
    public double computeRatio() {
        return (double) definitions / pages;
    }
    
    public void setDefinitions(int numDefinitions) {
        definitions = numDefinitions;
    }
    
    public int getDefinitions() {
        return definitions;
    }
    
}
