package ca.bcit.comp2526.a2c;

/**
 * CouldNotAddException.java
 * 
 * Exception which is thrown when unable to add element from the lists.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 *
 */
public class CouldNotAddException extends Exception {

    /**
     * generated serial version ID.
     */
    private static final long serialVersionUID = 1623876165767883229L;

    /**
     * construct CouldNotAddException object with error message.
     * @param message of the error
     */
    public CouldNotAddException(String message) {
        super(message);
    }
    
}
