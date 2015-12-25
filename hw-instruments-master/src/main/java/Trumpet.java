/**
 * An concrete class named Trumpet that extends from the Brass
 * and implements all the abstract methods of Brass
 * @author Alizain Charania
 * @version 1.0 Oct. 12 2015
 */
public class Trumpet extends Brass {

    /**
     * This is a constructor for the Trumpet class
     * @param price         The cost price of each instrument
     * @param property      The unique property of percussion instruments
     */
    public Trumpet(double price, String property) {
        super(price, property);
    }

    /**
     * A contrete method implemented, which was abstract in superclass
     * @return a String that makes the sound of this specific instrument
     */
    public String play() {
        return "Bong Bong boo boo!!";
    }

    /**
     * Overriding the toString() method to output a custom string
     * @return a String of meaningful statements
     */
    @Override
    public String toString() {
        String str = "Trumpet is a " + getProperty()
            + " instrument. Its price is $" + getPrice()
            + " and the unique serial number is " + getSerialNum()
            + ". The sound of this instrument is " + play();

        return str;
    }
}