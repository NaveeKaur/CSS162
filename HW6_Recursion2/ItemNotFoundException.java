/**
 * This class should be under 15 lines of code, and is an exercise in inheriting
 * from classes provided by the Java API.
 *
 * This class should have only two methods (both constructors) and no data items.

 * @author Created by Navee on 11/15/16.
 */
public class ItemNotFoundException extends Exception {

    /**
     *Empty constructor that calls the super class
     */
    public ItemNotFoundException() {super();}

    /**
     * Constructor that takes a message in its parameters.
     * @param message
     */
    public ItemNotFoundException(String message) {
        super(" ItemNotFoundException: "+message);
    }
}
