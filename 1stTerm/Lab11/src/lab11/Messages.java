package lab11;

public class Messages {

    public static void main(String[] args) {
        Thought parked = new Thought();
        Advice dates = new Advice();
        
        parked.message();
        
        dates.message(); // overridden
    }
    
}
