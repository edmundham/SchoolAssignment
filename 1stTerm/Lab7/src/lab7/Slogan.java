package lab7;

public class Slogan {

    private String phrase;
    private static int count = 0;
    
    public Slogan(String phrase) {
        this.phrase = phrase;
        count++;
    }
    
    public String toString() {
        return phrase;
    }
    
    public static int getCount() {
        return count;
    }
    
}
