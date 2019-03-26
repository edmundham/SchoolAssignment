package practice1;

public class Nana {
    public static void main(String[] args) {
        
        boolean overlap = true;
        int j = 0;
        
        String s1 = "This is a string.";
        String s2 = "This is a string.";
        
        while (overlap && j < s1.length()) {
           boolean found = false;
           
           int k = 0;
           while (!found && k < s2.length()) {
               if (s2.charAt(k) == s1.charAt(j)) {
                   found = true;
               }    else k++;
               if (!found) {
                   overlap = false;
               }
           }
           j++;
        }
        
        
    }
}
