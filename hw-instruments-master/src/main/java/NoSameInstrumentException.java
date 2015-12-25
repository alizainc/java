/**
 * An exception class named NoSameInstrumentException
 * which is thrown when an instrument of same serial number is bought
 * @author Alizain Charania
 * @version 1.0 Oct. 6 2015
 */
public class NoSameInstrumentException extends Exception {

    /**
     * This is a no args constructor for the NoSameInstrumentException class
     */
    public NoSameInstrumentException() {
        super("NotEnoughFundsException You cannot buy instruments"
            + " you already own. Two instruments can"
            + " never have same Serial Number. Check again!");
    }

    /**
     * This is a constructor for the NoSameInstrumentException class
     * @param msg       any message that is passed in when it is thrown
     */
    public NoSameInstrumentException(String msg) {
        super(msg + "\nYou cannot buy instruments"
            + " you already own. Two instruments can"
            + " never have same Serial Number. Check again!");
    }
}