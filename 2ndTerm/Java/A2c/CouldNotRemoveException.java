package ca.bcit.comp2526.a2c;

/**
 * CouldNotRemoveException.java
 * 
 * Exception which is thrown when unable to remove element from the lists.
 * 
 * @author Sunguk (Edmund) Ham, A00979841
 * @version 1.0
 *
 */
public class CouldNotRemoveException extends Exception {

    /**
     * generated serial version ID.
     */
    private static final long serialVersionUID = 1623876165767883229L;

    /**
     * construct CouldNotRemoveException object with error message.
     * @param message of the error
     */
    public CouldNotRemoveException(String message) {
        super(message);
    }
    
}
