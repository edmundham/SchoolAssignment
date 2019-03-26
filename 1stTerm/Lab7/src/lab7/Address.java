package lab7;

public class Address {

    private String streetAddress, city, state;
    private long zipCode;
    
    public Address(String street, String town, String st, long zip) {
        streetAddress = street;
        city = town;
        state = st;
        zipCode = zip;
    }
    
    public String toString() {
        String result;
        
        result = streetAddress + "\n";
        result += city + ", " + state + " " + zipCode;
        
        return result;
    }
    
    
}
