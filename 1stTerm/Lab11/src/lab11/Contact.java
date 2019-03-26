package lab11;

public class Contact implements Comparable {

    private String firstName, lastName, phone;
    
    public Contact(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
    
    public String toString() {
        return lastName + ", " + firstName + "\t" + phone;
    }
    
    public boolean equals(Object other) {
        return (lastName.equals(((Contact) other).getLastName()) 
                && firstName.equals(((Contact) other).getFirstName()));    
    }
    
    public int compareTo(Object other) {
        int result;
        
        String otherFirst = ((Contact) other).getFirstName();
        String otherLast = ((Contact) other).getLastName();
        
        if (lastName.equals(otherLast)) {
            result = firstName.compareTo(otherFirst);
        } else {
            result = lastName.compareTo(otherLast);
        }
        return result;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    
}
