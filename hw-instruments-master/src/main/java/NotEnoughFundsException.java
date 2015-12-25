/**
 * An exception class named NotEnoughFundsException
 * which is thrown when funds are less than the price
 * @author Alizain Charania
 * @version 1.0 Oct. 6 2015
 */
public class NotEnoughFundsException extends Exception {

    /**
     * This is a no args constructor for the NotEnoughFundsException class
     */
    public NotEnoughFundsException() {
        super("NotEnoughFundsException You cannot buy this instrument"
            + " due to insufficient funds!");
    }

    /**
     * This is a constructor for the NotEnoughFundsException class
     * @param msg       any message that is passed in when it is thrown
     */
    public NotEnoughFundsException(String msg) {
        super(msg + "\nYou cannot buy this instrument"
                + " due to insufficient funds!");
    }
}