package lab4;

public class Name {
    
    private String firstName;
    private String secondName;
    private String lastName;
    //private String otherName;
    
    public Name(String first, String second, String last) {
        firstName = first;
        secondName = second;
        lastName = last;
    }
    
    public String getFirst() {
        return firstName;
    }
    
    public String getSecond() {
        return secondName;
    }
    
    public String getLast() {
        return lastName;
    }
    
    public String firstMiddleLast() {
        return firstName + " " + secondName + " " + lastName;
    }
    
    public String lastFirstMiddle() {
        return lastName + ", " + firstName + " " + secondName;
    }
    
    public boolean equal(Name otherName) {
        return firstMiddleLast().equalsIgnoreCase(otherName.firstMiddleLast());
    }
    
    public String initials() {
        //return "" + firstName.toUpperCase().charAt(0) + secondName.toUpperCase().charAt(0) + lastName.toUpperCase().charAt(0);
        return "" + firstName.substring(0, 1) + secondName.substring(0, 1) + lastName.substring(0, 1);
    }
    
    public int length() {
        return firstName.concat(secondName.concat(lastName)).length();
    }
    
}
