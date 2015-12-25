/**
 * An exception class named DoNotOwnInstrumentException
 * which is thrown when the musician tries to sell an
 * instrument he doesnt own
 * @author Alizain Charania
 * @version 1.0 Oct. 6 2015
 */
public class DoNotOwnInstrumentException extends Exception {

    /**
     * This is a no args constructor for the DoNotOwnInstrumentException class
     */
    public DoNotOwnInstrumentException() {
        super("DoNotOwnInstrumentException You do not own this instrum"
            + "ent, so you cannot sell it.");
    }

    /**
     * This is a constructor for the DoNotOwnInstrumentException class
     * @param msg       any message that is passed in when it is thrown
     */
    public DoNotOwnInstrumentException(String msg) {
        super(msg + "\nYou do not own this instrum"
            + "ent, so you cannot sell it.");
    }
}