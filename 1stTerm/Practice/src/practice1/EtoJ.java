package practice1;

public class EtoJ {
    public static void main(String[] args) {
        
        String change;
        String original = new String("Eye to Joey");
        
        change = original.replace('e', 'j');
        
        System.out.println(original);
        System.out.println(change);
    }
}
