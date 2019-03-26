package q3;

/**
 * <p>This is the modified version of Address class that is
 * on the textbook. Also, Address class does not have any
 * exceptions since the program do not read inputs from user.</p>
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 */
public class Address {
    
    /**
     * <p>Long variable that is used for home zipCode.</p>
     */
    private static final long HOMEZIPCODE = 123456;
    
    /**
     * <p>Long variable that is used for school zipCode.</p>
     */
    private static final long SCHOOLZIPCODE = 987654;

    /**
     * <p>Street address of the address object.</p>
     */
    private String streetAddress;
    
    /**
     * <p>City name of the address object.</p>
     */
    private String city;
    
    /**
     * <p>State / Province of the address object.</p>
     */
    private String state;
    
    /**
     * <p>Zip code of the address object.</p>
     */
    private long zipCode;
    
    /**
     * <p>Zero parameter constructor that has nothing.</p>
     */
    public Address() {
        
    }
    
    /**
     * <p>Void method that sets home street address.</p>
     */
    public void setHomeStreetAddress() {
        streetAddress = "5807 Elsom Avenue";
    }
    
    /**
     * <p>Void method that sets home city name.</p>
     */
    public void setHomeCity() {
        city = "Burnaby";
    }
    
    /**
     * <p>Void method that sets home state / province.</p>
     */
    public void setHomeState() {
        state = "British Columbia";
    }
    
    /**
     * <p>Void method that sets home zip code.</p>
     */
    public void setHomeZipCode() {
        zipCode = HOMEZIPCODE;
    }
    
    /**
     * <p>Void method that sets school street address.</p>
     */
    public void setSchoolStreetAddress() {
        streetAddress = "4567 Willingdon Avenue";
    }
    
    /**
     * <p>Void method that sets school city name.</p>
     */
    public void setSchoolCity() {
        city = "Burnaby";
    }
    
    /**
     * <p>Void method that sets school state / province.</p>
     */
    public void setSchoolState() {
        state = "British Columbia";
    }
    
    /**
     * <p>Void method that sets school zip code.</p>
     */
    public void setSchoolZipCode() {
        zipCode = SCHOOLZIPCODE;
    }
    
    /**
     * <p>toString method that prints well-organized address.</p>
     * @return well-organized address.
     */
    public String toString() {
        String result;
        
        result = streetAddress + " ";
        result += city + ", " + state + " " + zipCode;
        
        return result;
    }
    
    
}