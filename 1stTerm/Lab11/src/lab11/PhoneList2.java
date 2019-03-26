package lab11;

public class PhoneList2 {

    public static void main(String[] args) {
        
        Contact test, found;
        Contact[] friends = new Contact[8];
        
        friends[0] = new Contact("John", "Smith", "610-555-7384");
        friends[0] = new Contact("John", "Smith", "610-555-7384");
        friends[0] = new Contact("John", "Smith", "610-555-7384");
        friends[0] = new Contact("John", "Smith", "610-555-7384");
        friends[0] = new Contact("John", "Smith", "610-555-7384");
        friends[0] = new Contact("John", "Smith", "610-555-7384");
        friends[0] = new Contact("John", "Smith", "610-555-7384");
        friends[0] = new Contact("John", "Smith", "610-555-7384");
        
        test = new Contact("Frank", "Phelps", "");
        found = (Contact) Searching.linearSearch(friends, test);
        
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("The contact was not found.");
        }
        System.out.println();
        
        Sorting.selectionSort(friends);
        
        test = new Contact("Mario", "Guzman", "");
        found = (Contact) Searching.binarySearch(friends, test);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("The contact was not found.");
        }
    }
    
}
