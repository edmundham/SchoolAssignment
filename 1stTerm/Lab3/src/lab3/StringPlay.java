package lab3;

public class StringPlay {
    public static void main(String[] args) {
        String college = new String ("poDunk College");
        
        String town = new String (" Seattle, USA"); // part A
        int stringLength;
        String change1, change2, change3;
        stringLength = college.length();
        
        System.out.println(college + " contains " + stringLength + " characters.");
        change1 = college.toUpperCase();
        change2 = college.replace('O', '*');
        change3 = college.concat(town);
        
        System.out.println("The final string is " + change3);
        
    }
}
