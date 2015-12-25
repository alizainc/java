/**
 * An exception class named NoLessThanOneInstrumentException
 * which is thrown when the Musician has less than one the last instrument
 * @author Alizain Charania
 * @version 1.0 Oct. 6 2015
 */
public class NoLessThanOneInstrumentException extends Exception {

    /**
     * This is a no args constructor for the NoLessThanOneInstrumentException
     */
    public NoLessThanOneInstrumentException() {
        super("NoLessThanOneInstrumentException You cannot"
            + " have less than one instrument."
            + " How can you be a Musician with no Instruments?");
    }

    /**
     * This is a constructor for the NoLessThanOneInstrumentException
     * @param msg       any message that is passed in when it is thrown
     */
    public NoLessThanOneInstrumentException(String msg) {
        super(msg + "\nYou cannot have less than one instrument."
            + " How can you be a Musician with no Instruments?");
    }
}