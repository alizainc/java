public class NoSuchUserException extends Exception {
    public NoSuchUserException (int num, Throwable t) {
        super("User " + num + " does not exist");
    }
}